#!/usr/bin/env groovy
def d = new Date()
println d

def x = -3.1415926 //def auto define type for variable
println x
//x = false //int cant cast to boolean
//println x

def pl = []
pl.add("java")
pl << "c++"
pl.addAll(["c", "bash"])
pl.each{
    println "programming language: $it"
}
pl.remove("c")
pl.remove(2)

pl.eachWithIndex{
    it, i -> println "$it: $i"
}

contained = pl.contains("java")
println contained
contained = "java" in pl
println contained


sortedPl = pl.sort(false) // sort without mutate original list
println sortedPl

println pl
pl.sort()
println pl

pl.add("java")
println pl

Collections.replaceAll(pl, "java", "groovy")
println pl

pl.clear()


def devMap = [:] //define an empty map
println devMap
devMap = ["firstname": "bob", "language": "Groovy"]
devMap.put("lastname", "Peter")
println devMap
devMap.each{
    println  "$it.key: $it.value"
}

for(ele in devMap){
    println ele.key + ":" + ele.value
}
devMap.eachWithIndex{
    it, i -> println "$i: $it"
}

assert devMap.containsKey("firstname")
assert devMap.containsValue("Groovy")

println devMap.keySet()
println devMap.values()


class Foo{
    final String name = "Robbert"
    String language
    protected void setLanguage(String language){
        this.language = language
    }
    def lastname
}

foo = new Foo()
println foo.name
println foo.language
println foo.lastname


x = 3
if(x == 1){
    println "one"
}else if(x==2){
    println "two"
}else{
    println "larger than two"
}

def y = 10
str = (y > 5)?"larger than 5":"smaller than 5"
println str

result = 0
for (i in 0 .. 10 ){
    result += i
}
println result
array = (0..10).toArray()
println array


user = "Bob"
println user.capitalize()


int func(int x, int y){
    return x + y
}
println func(10, 20)

args = [0, 1]
println func(*args)


//闭包
//def func = { [ arguments list -> ] statement }
//如果闭包只接受一个参数, 则可以省略不写, 默认用it来调用
def closure = {
    println it
}
//不接受参数的闭包
def noParamClosure = { -> true }
//闭包的调用
closure.call("string")
closure("string")

def closure02 = {
    a, b -> a + b
}
println closure02(10, 20)
