#!/bin/bash
for i in {0..10};do
{

lftp -u user,pass 1.2.3.4 <<EOF
mget *
bye
EOF

} &

done
wait

