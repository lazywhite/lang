a=0
while true;do

let a=a+1

if [ $a -eq 10 ];then
    echo "match"
    break
else
    echo $a
fi
done
