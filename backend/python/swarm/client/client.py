import requests
from datetime import datetime
from configparser import ConfigParser
import os
import json
from uuid import uuid4
import csv
import subprocess
import logging
from logging.handlers import TimedRotatingFileHandler
import sys


def check_dir(path):
    if not os.path.isdir(path):
        os.makedirs(path)

cfg = ConfigParser()
ini_path = os.path.dirname(os.path.abspath(__file__)) + '/client.ini'
cfg.read(ini_path)
delay = cfg.getint('default', 'delay')
time_range = cfg.getint('default', 'range')
api_endpoint = cfg.get('default', 'api_endpoint')
host = cfg.get('default', 'host')
credential = cfg.get('default', 'credential')

csv_dir = cfg.get('default', 'csv_dir')
csv_delimiter = cfg.get('default', 'csv_delimiter')
tables = cfg.get('default', 'tables').split(',')
log_dir = cfg.get('default', 'log_dir')
post_timeout = cfg.getint('default', 'post_timeout')


start_ts = cfg.get('test', 'start_ts')
end_ts = cfg.get('test', 'end_ts')

check_dir(csv_dir)
check_dir(log_dir)


log_file = '%s/client.log' % log_dir
time_handler = TimedRotatingFileHandler(log_file, when='D', interval=1, backupCount=60)
time_handler.suffix = '%Y-%m-%d'
time_handler.setLevel('INFO')

fmt = '%(asctime)s - %(funcName)s - %(lineno)s - %(levelname)s - %(message)s'
formatter = logging.Formatter(fmt)
time_handler.setFormatter(formatter)

logger = logging.getLogger()
logger.setLevel('INFO')
logger.addHandler(time_handler)


now_ts = int(sys.argv[1])
if not start_ts:
    start_ts = now_ts - delay
if not end_ts:
    end_ts = start_ts + time_range


for table in tables:
    headers = {}
    headers['credential'] = credential
    headers['charset'] = "utf-8"
    headers['Host'] = host

    pdata = {}
    pdata["version"] = "1.0"
    pdata["uuid"] = str(uuid4())
    pdata['startts']  = start_ts
    pdata['endts']  = end_ts
    pdata['table']  = table

    logger.info("fetching %s" % table)
    try:
        resp = requests.post(api_endpoint, data=pdata, headers=headers, timeout=post_timeout)
        data = json.loads(resp.text).get("data")
    except:
        logger.exception("error")
        continue
    
    if not data:
        logger.warning("%s: no data fetched" % table)
        continue
         

    if len(data) >= 2:
        logger.info("fetched data: %s" % table)

        try:
            file_date = datetime.strptime(data[0][-1], '%Y%m%d%H%M')
            file_str = file_date.strftime('%Y%m%d%H%M')
            
            file_year = file_date.strftime("%Y")
            file_month = file_date.strftime("%m")

            file_dir = "%s/%s/%s/%s" % (csv_dir,file_year,file_month,table)
            check_dir(file_dir)        

            file_abs_name = "%s/%s/%s/%s/%s_%s.csv" % (csv_dir,file_year,file_month,table,table,file_str)

            with open(file_abs_name, 'wt') as f:
                w = csv.writer(f, delimiter=csv_delimiter)
                w.writerows(data[1:])
        except:
            logger.exception("failed to save csv")
            continue
        logger.info("saved csv: %s" % file_abs_name)
    else:
        logger.warning("%s no data, skipping..." % table)
