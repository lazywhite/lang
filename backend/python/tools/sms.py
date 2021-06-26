#!/usr/bin/python
# -*- coding: utf8 -*-

import requests
import sys
import json

MAIN_URL = "http://wt.3tong.net/json/sms/Submit"
ACC = ""
PWD = ""

def send_sms_by_3tong(phones, topic,  content='warning'):
    params = {}
    params['account'] = ACC
    params['password'] = PWD
    params['action'] = 'send'
    params['phones'] = phones
    params['content'] = topic + content
    params['sign'] = ''
    headers = {'content-type': 'application/json'}
    n = 0
    while n <= 3:
        r = requests.post(MAIN_URL, data=json.dumps(params), headers=headers)
        result = r.json()
        if int(result['result']) != 0:
            continue
        else:
            break




if __name__ == '__main__':
    to = sys.argv[1]
    subject = sys.argv[2]
    body = sys.argv[3]
    send_sms_by_3tong(to, subject, body)

