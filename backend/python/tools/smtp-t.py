#!/usr/bin/python
# -*- coding: utf-8 -*-
"""
Zabbix SMTP Alert script for gmail.
"""

import sys
import smtplib
from email.MIMEText import MIMEText
from email.Header import Header
from email.Utils import formatdate

# Mail Account
MAIL_ACCOUNT = ''
MAIL_PASSWORD = ''

# Sender Name
SENDER_NAME = u'Zabbix Alert'

# Mail Server
SMTP_SERVER = 'smtp.exmail.qq.com'
SMTP_PORT = 465
# TLS
SMTP_TLS = True

def send_mail(recipient, subject, body, encoding='utf-8'):
    msg = MIMEText(body, 'plain', encoding)
    msg['Subject'] = Header(subject, encoding)
    msg['From'] = Header(SENDER_NAME, encoding)
    msg['To'] = recipient
    msg['Date'] = formatdate()
    try:
        server = smtplib.SMTP_SSL(SMTP_SERVER, port=SMTP_PORT)
        server.login(MAIL_ACCOUNT, MAIL_PASSWORD)
        server.sendmail(MAIL_ACCOUNT, recipient, msg.as_string())
    except Exception as e:
        raise e
    finally:
        # close session
        server.close()

if __name__ == '__main__':
    """
    recipient = sys.argv[1]
    subject = sys.argv[2]
    body = sys.argv[3]
    """
    if len(sys.argv) == 4:
        send_mail(
            recipient=sys.argv[1],
            subject=sys.argv[2],
            body=sys.argv[3])
    else:
        print u"""requires 3 parameters (recipient, subject, body)
\t$ zabbix-gmail.sh recipient subject body
"""

