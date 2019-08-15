====== 随机数
echo $((RANDOM % 3))

====== 计算
a=10
((a=a+10))
let "a=a+10" # 必须加引号
b=$(($a+10))

# 数制转换
a=08
b=$((10#$a+10))
======= 字典
#必须先声明
declare -A dic
dic=([key1]="value1" [key2]="value2" [key3]="value3")

#打印指定key的value
echo ${dic["key1"]}
#打印所有key值
echo ${!dic[*]}
#打印所有value
echo ${dic[*]}

#遍历key值
for key in $(echo ${!dic[*]})
do
    echo "$key : ${dic[$key]}"
done


===== 数组
list=("value1" "value2" "value3")
#打印指定下标
echo ${list[1]}
#打印所有下标
echo ${!list[*]}
#打印数组下标
echo ${list[*]}
#数组增加一个元素
list=("${list[@]}" "value3")


====== 字符串
str="apple, tree, apple tree"
echo ${str/apple/APPLE}   # 替换第一次出现的apple
echo ${str//apple/APPLE}  # 替换所有apple
 
echo ${str/#apple/APPLE}  # 如果字符串str以apple开头，则用APPLE替换它
echo ${str/%apple/APPLE}  # 如果字符串str以apple结尾，则用APPLE替换它

echo ${#str} # 打印字符串长度

echo ${str:2} # 第二个字符到末尾(向右)
echo ${str:2:3} # 从第二个字符连续3个(向右)
echo ${str: -2} # 从倒数第二个字符到开头(向左)
echo ${str: -2:3} # 从倒数第二个字符(向左)连续3个字符
echo ${str}|cut -c 1-5 

# 字符串in test, 注意变量前后顺序
a="hello world"
b="hello"
if [[ $a =~ $b ]];then
  echo "match"
fi


======= 流程控制 ==========

#========= if ========
if [ -d /usr ];then
    echo 'done'
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
