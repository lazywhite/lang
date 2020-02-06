import java.util.*


val items = listOf("apple", "banana", "kiwi", "avoca")

fun sum(a: Int, b:Int): Int{
    return a + b
}
fun printNum(a: Int, b: Int):Unit{
    println("sum of $a and $b is ${a + b}") //string template
}
fun maxOf(a: Int, b: Int): Int{
    return if(a > b) a else b
}
fun getInt(obj: Any): Int?{
    if(obj is String){
        return obj.length
    }else if (obj is Int){
        return obj
    }else{
        return null
    }
}
printNum(10, 20)
println(maxOf(10, 20))
println(getInt("test"))

var index = 0
while (index < items.size){
    println("item is ${items[index]}")
    index++
}

fun describe(obj: Any): String{
    var t = when (obj){
        is Int -> "Int"
        is String -> "String"
        else -> "Unknown"
    }
    return t
}

println(describe(100))
/*
var start = 0
var end = 10
for (i in start..end-1 step 2){ //包括边界
    println(i)
}
for (i in start..end){
    println(i)
}
for (i in end downTo start){ //包括边界
    println(i)
}
*/

items
    .filter {it.startsWith("a")}
    .sortedBy {it}
    .map {it.toUpperCase()}
    .forEach {println(it)}

val myMap = mapOf("a" to 1, "b" to 2, "c" to 3)
for((k, v) in myMap){
    println("key is $k, value is $v")
}

var ss:String? = "test"
println(ss)
