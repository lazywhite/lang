#!/usr/local/bin/lua
str1 = "hello"
str2 = "world"
local apple, orange
local m, n = 10  --[[ n is nil --]]
apple = 10
orange = 20
print(str1.." "..str2)
print(#str1) --[[ length of string --]]
print(type(str1))  --[[ this is a comment --]] print(apple + orange)
print(type(nil))


--[[ while loop --]]
while (apple < 20) do
    print("value of apple:", apple)
    apple = apple + 1
    if (apple > 15) then
        break
    end
end



--[[ for loop --]]
for i=10,1,-1
    do
        print(i)
    end

--[[ repeate loop --]]
a = 10
repeat
    print("value of a:", a)
    a = a + 1
until(a > 15)


function max(num1, num2)
    local result
    if (num1 > num2) then
        result = num1
    else
        result = num2
    end
    return result
end
print(max(apple, orange))


add5 = function(num)
    return num + 5
end
print(add5(10))


function add(num1, func)
    return func(num1)
end

print(add(10, add5))


--[[ function with variable argument --]]
function average(...) 
    result = 0
    local arg={...}
    for i, v in ipairs(arg) do
        result = result + v
    end
    return result/#arg
end
print(average(1,2,3,4,5))

--[[ initialize a string --]]
st1 = "hello"
st2 = 'hello'
st3 = [["lua tutorial""]] --[[ double quote will be outputed --]]

print(string.reverse(st3))
print(string.rep(st3, 3))


array = {"lua", "tutorial"}
for i=0, 2 do
    print(array[i])
end

mytable = {}
print(type(mytable))
mytable['key'] = 'value'
print(mytable['key'])

