#!/usr/bin/env python
# -*- coding: utf8 -*-
from __future__ import print_function
import requests
import sys
import json
'''
# get the webapi url
    login Slack.com
    Browse Apps
        Custom Integration
            Incoming WebHooks
                https://nexttaodev.slack.com/services/B2KELQPPU
# post a json formatted payload
'''

url = "https://hooks.slack.com/services/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"

channel = "#alert"
username = "zabbix"
icon_emoji = ":ghost:"
logfile = '/tmp/send_slack.log'

if __name__ == '__main__':

    to = str(sys.argv[1])
    subject = str(sys.argv[2])
    message = str(sys.argv[3])

    content = "%s: %s\n\n%s" % (to, subject, message)

    post = {}
    payload = {}
    payload['channel'] = channel
    payload['icon_emoji'] = icon_emoji
    payload['username'] = username
    payload['text'] = content
    post['payload'] = json.dumps(payload)
    with open(logfile, 'a') as log:
        try:
            resp = requests.post(url, data=post)
            print(resp.content, file=log)
        except Exception as e:
            print(e, file=log)
