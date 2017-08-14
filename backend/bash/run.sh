#! /bin/bash
#
# Copyright (C) 2017 white <white@Whites-Mac-Air.local>
#
# Distributed under terms of the MIT license.
#
#========= if ======== #man test
if [ -d /usr ];then
    echo 'alkdfj'
fi

#========= For 循环 ========
for i in 10 20 30;do
    echo $i
done

array=(str1 str2)
for i in ${array[@]};do
    echo $i
done

for ((i=0;i<5;i++));do
    echo $i
done

#========= Case ========
ENV=prod
case $ENV in 
    prod)
        echo "prod"
        ;;
    *)
        echo "none"
        ;;
esac


#========= While ========

COUNTER=0
while [ $COUNTER -lt 10 ];do
    echo "current index: " $COUNTER
    let COUNTER=COUNTER+1
done


#========= Until ========
#until [ X${EXIT} == X"y" ];do
#    read EXIT
#done


#========= Select ========
echo "What is your favourite OS?"
select var in "Linux" "Gnu Hurd" "Free BSD" "Other"; do
	if [ -n "$var" ]; then 
		echo "You select the choice '$var'" 
		break   #由于select是个循环，通过break来跳出
	else 
		echo "Invaild selection" 
	fi 
done
echo "You have selected $var" #仍然可以访问变量


#========= Function ========
function func {
    echo $#  参数个数
    echo $*  参数被视为一个整体
}
func 1 2 3 

func02(){
    echo $$ 脚本PID
    for i in  $@;do
        echo $i
    done
}
func02 10 20 30
