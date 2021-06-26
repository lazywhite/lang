from flask import Flask, request, jsonify, make_response
from impala.dbapi import connect
from configparser import ConfigParser
import sys
import os
from kazoo.client import KazooClient
import random
import re
from datetime import datetime, timedelta
import csv
import logging
from logging.handlers import TimedRotatingFileHandler


def connection(zkhost, znodeName, serviceKeyword, database):
    host_list = discoveryThriftSerivcehost(zkhost, znodeName, serviceKeyword)
    hostLength = host_list.__len__()
    random.seed()
    isConnected = False
    conn = None
    cursor = None
    while isConnected is False and hostLength > 0:
        index = random.randint(0, hostLength-1)
        hostStr = host_list.pop(index).split(":")
        try:
            conn = connect(host=hostStr[0], port=int(hostStr[1]), auth_mechanism="GSSAPI", 
                            kerberos_service_name="hive", database=database)
            cursor = conn.cursor()
            isConnected = True
        except:
            logger.exception("hive connect error")
            isConnected = False
            if hostLength > 1:
                logger.info("Can not connect "+hostStr[0]+":"+hostStr[1]+", try another thrift server...")
            else:
                logger.error("Can not connect hiveserver2, please check the connection config and the hiveserver")
                return 0
        hostLength -= 1
    return conn, cursor

def discoveryThriftSerivcehost(zkhost,znodeName,serviceKeyword):
    zkClient = KazooClient(hosts=zkhost)
    zkClient.start()
    result = zkClient.get_children(znodeName)
    zkClient.stop()
    if len(result) == 0:
        logger.warning("no thriftServer found...")
        return []
    else:
        logger.info("found thriftServer2")
    host_list = []
    p = r'%s=[^;]*;' % serviceKeyword
    for i in result:
        m = re.findall(p, i)
        for i in m:
            host_list.append(i.split(";")[0].split("=")[1])
        
    return host_list




app = Flask(__name__)


ini_path = os.path.dirname(os.path.abspath(__file__)) + '/server.ini'

cfg = ConfigParser()
cfg.read(ini_path)
zk_list = cfg.get('default', 'zookeeper')
hive_db = cfg.get('default', 'hive_db')
yarn_queue = cfg.get('default', 'yarn_queue')
znode = cfg.get('default', 'znode')
service_keyword = cfg.get('default', 'service_keyword')
path = cfg.get('default', 'url')
tables = cfg.get('default', 'tables').split(',')
delay = cfg.getint('default', 'delay')
log_dir = cfg.get('default', 'log_dir')


if not os.path.isdir(log_dir):
    os.makedirs(log_dir)

run_day = datetime.now().strftime("%Y%m%d")

log_file = '%s/server.log' % log_dir
time_handler = TimedRotatingFileHandler(log_file, when='D', interval=1, backupCount=60)
time_handler.suffix = '%Y-%m-%d'
time_handler.setLevel('INFO')

fmt = '%(asctime)s - %(funcName)s - %(lineno)s - %(levelname)s - %(message)s'
formatter = logging.Formatter(fmt)
time_handler.setFormatter(formatter)

logger = logging.getLogger()
logger.setLevel('INFO')
logger.addHandler(time_handler)


@app.route(path, methods=["POST", "GET"])
def dump():
    result = {}
    conn, cursor = connection(zk_list, znode, service_keyword, hive_db)
    if not conn or not cursor:
        result['status'] = 20
        result['msg'] = "cant connect to hive..."
        return jsonify(result)


    request_info = {}
    request_info['headers'] = request.headers
    request_info['method'] = request.method
    request_info['querystring'] = ""
    request_info['request_uri'] = request.full_path
    request_info['request_body'] = request.form


    # 参数处理
    if request.method == 'POST':
        version = request.form['version']
        req_uuid = request.form['uuid']
        startts = request.form["startts"]
        endts = request.form["endts"]
        table = request.form["table"]

    result['version'] = version
    result['uuid'] = req_uuid

    if not startts:
        result['status'] = 30
        result['msg'] = "no start timestamp provided"

        response = make_response(jsonify(result))

        resp_info = {}
        resp_info['status'] = response.status_code
        resp_info['size'] = response.calculate_content_length()
        resp_info['headers'] = response.headers
        resp_info['response-body'] = result


        log_info = {"request": request_info, "response": resp_info}
        logger.info(log_info)

        return response



    if table not in tables:
        logger.info("table not found")
        result['status'] = 40
        result['msg'] = "table not found ..."

        response = make_response(jsonify(result))

        resp_info = {}
        resp_info['status'] = response.status_code
        resp_info['size'] = response.calculate_content_length()
        resp_info['headers'] = response.headers
        resp_info['response-body'] = result


        log_info = {"request": request_info, "response": resp_info}
        logger.info(log_info)

        return response

    start_date = datetime.fromtimestamp(int(startts))
    partition = start_date.strftime("%Y%m%d%H%M")

    # set yarn queue
    if yarn_queue:
        cursor.execute("set tez.queue.name=%s" % yarn_queue)

    logger.info("===== trying to fetch normal data =====")
    sql1 = 'select * from %s where p = "%s"' % (table, partition)
    logger.info(sql1)
    cursor.execute(sql1)
    data = cursor.fetchall()

    if len(data) > 0:
        result['status'] = 0
        result['data'] = data
        response = make_response(jsonify(result))

        resp_info = {}
        resp_info['status'] = response.status_code
        resp_info['size'] = response.calculate_content_length()
        resp_info['headers'] = response.headers
        resp_info['response-body'] = result

        log_info = {"request": request_info, "response": resp_info}
        logger.info(log_info)
        conn.close()

        return response

    else:
        # 假数据逻辑
        logger.info("===== trying to fetch old data =====")
        partition = (start_date + timedelta(days=-delay)).strftime("%Y%m%d%H%M")

        fake_str = start_date.strftime("%Y-%m-%d %H:%M")
        fake_partition = start_date.strftime("%Y%m%d%H%M")

        sql1 = 'select * from %s where p = "%s"' % (table, partition)
        logger.info(sql1)
        cursor.execute(sql1)
        data = cursor.fetchall()

        if len(data) == 0:
            logger.warning("===== no old data found =====")
            result['status'] = 0
            result['data'] = data
        else:
            r = []
            for i in data:
                p = list(i)
                p[0] = fake_str
                p[-1] = fake_partition
                r.append(p)
            result['status'] = 0
            result['data'] = r
        response = make_response(jsonify(result))

        resp_info = {}
        resp_info['status'] = response.status_code
        resp_info['size'] = response.calculate_content_length()
        resp_info['headers'] = response.headers
        resp_info['response-body'] = result

        log_info = {"request": request_info, "response": resp_info}
        logger.info(log_info)
        conn.close()

        return response

