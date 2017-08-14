export Demo=200

function test {
    local Demo=100
    echo $Demo
}

function test2 {
    Demo=300 # 不加local关键词, 会将global Demo的值修改
    echo $Demo
}

#test
test2
echo $Demo
