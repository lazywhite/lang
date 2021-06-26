#!/bin/sh

# 每小时11,26,41,56 执行
export PATH=/bin:/sbin:/usr/bin:/usr/sbin

while true;do
minute=`date +%M`
b=`expr $minute % 15`

if [ $b -eq 11 ];then
ts=`date +%s`
/conda3/bin/python /client/client.py $ts &
fi

sleep 60
done
