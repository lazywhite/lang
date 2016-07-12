#!/bin/bash
export PATH=/bin:/usr/bin:/sbin:/usr/sbin
NOW=`date +%F-%H.%M.%S`
HOST=
SSH_PORT=22
TAG=jenkins
MD5_FILE=/home/jenkins/md5all
CWD=`pwd`
PROJECT_LIST="item1 item2 item3 item4 item5 item6"
DEPLOY_LIST=""
LOG_FILE=/home/jenkins/deploy_$NOW.log
declare -A PROJECT_TARGET=(["item1"]="item1/target/item.war"
                           ["item2"]="item2/target/item.war"
                           ["item3"]="item3/target/item.war"
                           ["item4"]="item4/target/item.war"
                           ["item5"]="item5/target/item.war"
                           ["item6"]="item6/target/item6.war")

declare -A PROJECT_NEW_MD5=()

get_new_md5 () {
    for proj in $PROJECT_LIST;do
        PROJECT_NEW_MD5["$proj"]=`md5sum ${PROJECT_TARGET["$proj"]}|awk '{print $1}'`
    done
}


gen_md5_file() {
## register new md5 of all project
cat > $MD5_FILE <<EOF
declare -g -A PROJECT_MD5=(
["admin"]=${PROJECT_NEW_MD5["admin"]}
["api"]=${PROJECT_NEW_MD5["api"]}
["task"]=${PROJECT_NEW_MD5["task"]}
["web"]=${PROJECT_NEW_MD5["web"]}
["xdb"]=${PROJECT_NEW_MD5["xdb"]})
EOF
}

get_deploy_list () {
    echo ${PROJECT_MD5}
    for proj in $PROJECT_LIST;do
        if [ ${PROJECT_MD5["$proj"]} != ${PROJECT_NEW_MD5["$proj"]} ];then
            DEPLOY_LIST=$DEPLOY_LIST" $proj"
        fi
    done
}


deploy () {
    echo "Deploying $1" >> $LOG_FILE
    scp -P $SSH_PORT ${PROJECT_TARGET["$1"]} root@$HOST:/root/install/$1-$TAG.$NOW.war
    ssh -p $SSH_PORT root@$HOST "bash -l -c \"/root/install/install-$1.sh /root/install/$1-$TAG.$NOW.war\""
    echo "Deployed $1" >> $LOG_FILE
}


echo '########################################'
echo $BUILD_TAG >> $LOG_FILE
echo $WORKSPACE >> $LOG_FILE
echo $BRANCH_NAME >> $LOG_FILE
# main program

cd $CWD/jiedianqian # enter root pom directory
if [ ! -e $MD5_FILE ];then
    get_new_md5 && gen_md5_file
    exit 100
else
    source $MD5_FILE && get_new_md5 && get_deploy_list && gen_md5_file

    for proj in ${DEPLOY_LIST[@]};do
        echo "deploying $proj"
        deploy $proj
    done
    echo '########################################'
fi

