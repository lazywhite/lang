: ${PGUSER:=100} # PGUSER is not set, export PGUSER=100
echo 'PGUSER ' $PGUSER

PGPASS=${PGUSER:-200} # PGUSER is set, PGPASS=PGUSER
echo 'PGPASS ' $PGPASS

PGPASS1=${PGUSER1:-200} # PGUSER1 is not set, PGPASS=200
echo 'PGPASS1 ' $PGPASS1


## print length of string
echo ${#PGUSER}

echo 'PGUSER1 ' $PGUSER1


PGHOST=${PGUSER1:+200} # PGUSER1 is not set, PGHOST=""
echo 'PGHOST ' $PGHOST

PGHOST1=${PGUSER:+200} # PGUSER is set, PGHOST=200
echo 'PGHOST1 ' $PGHOST1

branch='remote/origin/master' ## remove matched part from string

echo ${branch//remote\/origin\//}
