#!/bin/bash
export PATH=/bin:/usr/bin:/sbin:/usr/sbin
export FLASK_APP=/server/server.py


principle=`grep principle /server/server.ini|awk -F '=' '{print $2}'`
keytab=`grep keytab /server/server.ini|awk -F '=' '{print $2}'`

/usr/bin/kinit  -kt $keytab $principle
/conda3/bin/flask run --host=0.0.0.0
