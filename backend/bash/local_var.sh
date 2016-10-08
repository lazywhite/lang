export Demo=200

function test {
    local Demo=100
    echo $Demo
}

function test2 {
    local Demo=300
    echo $Demo
}

test
test2
echo $Demo
