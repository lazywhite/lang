#!/usr/bin/env python
# -*- coding: utf-8 -*-
import requests
import json

from commands import getstatusoutput

zbx_agent_conf = '''
LogFile=/tmp/zabbix_agentd.log
EnableRemoteCommands=1
Server=127.0.0.1,%s
ListenPort=10050
ListenIP=0.0.0.0
ServerActive=%s
Hostname=%s
HostMetadataItem=system.uname
AllowRoot=0
User=zabbix
Include=/usr/local/zabbix/etc/zabbix_agentd.conf.d/*.conf
'''

fail_msg = '''
Failed to Initialize Zabbix Agent
'''
readme_file = '/root/README'

def main():
    ip_url = "http://169.254.169.254/latest/meta-data/local-ipv4"
    custom_url = "http://169.254.169.254/openstack/latest/meta_data.json"

    try:
        data = json.loads(requests.get(custom_url).text)
        proxy_ip = data.get("meta").get("zabbix_proxy")
        local_ip = requests.get(ip_url).text
        if proxy_ip and local_ip:
            init_zbx_agent(proxy_ip, local_ip)
            start_ntp()
            create_lock()
            return 0
    except Exception as e:
        print e
        fail()


def init_zbx_agent(proxy_ip, local_ip):
    with open("/usr/local/zabbix/etc/zabbix_agentd.conf", 'wt') as f:
        f.write(zbx_agent_conf % (proxy_ip, proxy_ip, local_ip))

    getstatusoutput("/etc/init.d/zabbix-agent restart")

def fail():
    with open(readme_file, 'wt') as f:
        f.write(fail_msg)

def create_lock():
    getstatusoutput("/usr/bin/touch /tmp/cloud_init.lock")

def start_ntp():
    getstatusoutput("systemctl restart ntpd")


if __name__ == '__main__':
    main()

