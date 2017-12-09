package com.local

//自动为每个constructor的property生成componentX()方法,  与主构造器属性出现的顺序相同
//还要hashCode(), toString(), copy(), equals()方法
data class User(val name:String, val id:Int){}

enum class Color(val rgb:Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

class Turtle{
    fun left(){
        println("moving left")
    }
    fun right(){
        println("moving right")
    }
}

interface A {
    fun foo() { print("com.local.A") }
    fun bar()
}
interface B {
    fun foo() { print("com.local.B") }
    fun bar() { print("bar") }
}
class C : A {
    override fun bar() { print("bar") }
}
class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }
    override fun bar() {
        super<B>.bar()
    }
}

sealed class Expr{
    data class Const(val number: Double) : Expr()
    data class Sum(val e1: Expr, val e2: Expr) : Expr()
    object NotANumber : Expr()

}
// 类型别名
typealias Ench = Int;
class Point(var x: Ench, var y: Ench){
    private var prop01:String? = null
    val size: Int?
        get() = x * y

    var name:String?
        get() = this.prop01
        set(value){
            this.prop01 = value
        }

    val prop02:String?
        get() = "readonly property"
}

class Person(val map:Map<String, Any?>){
    val name:String by map  //
    val age:Int by map
}

object Resource{
    var name = "resource"
}

class Pair<K, V>(val first:K, val second:V) {
    operator fun component1():K{
        return first
    }
    operator fun component2():V{
        return second
    }
}

class LazyExample{
    val lazy:String by lazy{
        "my lazy"
    }

    val bockLazy:String by lazy(LazyThreadSafetyMode.SYNCHRONIZED){  // 线程安全的lazy
        "my blocking lazy"
    }
}

fun getLength(obj:Any): Int?{
    if(obj is String){ // type check
        return obj.length //automatic type cast
    }
    return null
}

fun mapTest(){
    var map = hashMapOf<String, Any>()
    map.put("one", 1)
    map.put("two", 1)
    for((key, value) in map){
        println("$key: $value")
    }
}

//while and do-while
fun loopTest(size:Int):Unit{
    var i = 0
    while(i<size) {
        println(i++)
    }

    do {
        println(i--)
    } while(i>0)

}

fun interfaceTest(){
    var d = D()
    d.foo()
    d.bar()
}

fun caseTest(num:Int):String{
    return when(num){
        in 1..3 -> "case01"
        4-> "case02"
        6, 7 -> "case03"
        else -> "default"
    }
}

fun dataClassTest(){
    var user = User("bob", 1)
//    var (name, id)  = user  // unpack properties
//    var user02 = user.copy("andy", 2)
    var user02 = user.copy()
//    var user02 = user.copy("bob") //拷贝的过程中赋值
    println(user02 === user) // 比较指针
    println(user02 == user) // 比较值
}

fun forTest(list: List<Any>){
    for(item in list){
        println(item)
    }
    for(i in list.indices){
        println(list[i])
    }
}

fun delegateTest(){
    var e = Example()
    println(e.p)
    e.p = "new"
}

fun lazyTest(){
    val le = LazyExample()
    println("lazy = ${le.lazy}")
    println("lazy = ${le.lazy}")
    println("blockLazy = ${le.bockLazy}")
}

fun observableTest(){
    val le = Example()
    le.name = "new name"
}
fun vetoableTest(){
    val le = Example()
    le.finalName = "new name"
    println(le.finalName)
    le.finalName = "good"
    println(le.finalName)
}

fun notNullPropertyTest(){
    val example = Example()
    try{
        example.age
    }catch(e: IllegalStateException){
        example.init(10)
        example.age
    }
}

fun propertyInMap(){
    var map = mapOf("name" to "bob", "age" to 10)
    var p = Person(map)
    println(p.name)
}

fun isOdd(x:Int):Boolean{
    return x % 2 != 0
}

fun length(s:String):Int{
    return s.length
}

fun funcRefTest(){
    var list = listOf(1, 2, 3)
    println(list.filter(::isOdd))
}

fun composeTest(){
    val list = listOf("bob", "alice", "na")
    val oddLength = compose(::isOdd, ::length)
    println(list.filter(oddLength))
}

fun <A,B,C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return {x -> f(g(x))}
}

fun test(x: Int) = x > 10
//fun com.local.test(x: Int) = {x > 10}  // 大括号可省略
//fun com.local.test(x: Int):Boolean = x > 10  // 不能写返回值

fun lambdaTest(){
    val fruits = listOf("apple", "orange", "peach")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }


    val list = listOf(-1, 3, -2, 4)
    val positives = list.filter { x -> x > 0 }
// or
//  val positives = list.filter { it > 0 }
}

fun Int.test(){
    println("extension function com.local.test")
}

fun extentionFunTest(){
    var a:Int = 10
    a.test()
}

fun singletonTest(){
    var r1 = Resource
    var r2 = Resource
    Resource.name = "new"
    println(Resource.name)
}

fun varNullTest(){
    var m :String? = null
    var n :String? = "com.local.test"
    println(m?.length ?: 0) // if m is not null, execute m.com.local.length
    println(n?.length ?: 0)
}


fun propertyTest(){
    var p = Point(10, 20)
    println(p.size)
    println(p.name)
    println(p.prop02)
}

fun sealedClassTest(){
    var e1 = Expr.Const(10.0)
    println(e1.number)
}

fun propertyUnpackTest(){
    val pair = Pair(1, "str")
    val (key, value) = pair //unpack, 必须定义componentX()
    print("$key and $value")
}

fun enumTest(){
    var c1 = Color.RED
    var c2 = Color.valueOf("BLUE")
//    var c3 = Color(0xFAFAFA)  // enum 无法实例化
    println(c1.rgb)

}

fun defaultFunParam(a:Int = 10, b:String = "com.local.test"){
    println("$a and $b")
}

fun withTest(){
    var t = Turtle()
    with(t){
        left()
        right()
    }
}
fun main(args: Array<String>) {
    println(getLength("com.local.test"))
    loopTest(3)

    val testList = listOf(1, 2, "bob")
    forTest(testList)
    caseTest(10)
    dataClassTest()
    mapTest()
    delegateTest()
    lazyTest()
    observableTest()
    vetoableTest()
    notNullPropertyTest()
    propertyInMap()
    funcRefTest()
    composeTest()
    println(test(100))
    lambdaTest()
    extentionFunTest()
    singletonTest()
    varNullTest()
    propertyTest()
    sealedClassTest()
    interfaceTest()
    propertyUnpackTest()
    enumTest()
    defaultFunParam()
    withTest()
}
