数据类型
    Any
        AnyVal
            Byte
            Short
            Int
            Long
            Boolean
            Char
            Float
            Double
            Unit
        AnyRef
            Option
            List
    Nothing
    Null

常用数据类型
    Map
        scala.collection.mutable.Map
        var b = Map[String, Any]()
        b += ("key1"->"value1", "key2"->"value2")
        b("key1) = 100 //赋值, 更新
        b get "key1" // 键不存在返回None
        b("key1") //键不存在会报错
        b remove "key1" //删除键值
        b contains "key1" //成员检测
        b.keys
        b.values
        b.size

        var i = b.keysIterator
        while(i.hasNext){
            i.next()
        }
	Set
        scala.collection.mutable.Set
		var a = Set[Any]()
        a add 10
        a remove 10
        a.size
        a.iterator
	List
        列表是不可变的, 数据结构为linked list
		var a:List[Any] = List(1, 'c', 'string')
		a.toSet
        a.head(首元素)
        a.tail(除首元素的所有元素)
        a.isEmpty
        a.reverse
        List.tabulate()
        a(2) # 按下标获取元素, throw java.langIndexOutOfBoundsException
        a.lift(3) # 返回optional

    ArrayBuffer
        scala.collection.mutable.ArrayBuffer

        var a = ArrayBuffer[Any]()
        a append 10 
        a prepend 1
        a contains 1
        a.insert(0, 19)
        a.indexOf(10)
        a remove 0 // 按照index删除
        a(0) //按下标获取元素
        a(0) = 10 //更新
        a.size

        scala.util.Sorting.quickSort(fruits)
        
    Iterator
        while(i.hasNext){println(i.next)}
        i.foreach
    Tuple
        var a = (1, 2, 3)
        a._1 # 按下标访问元素, 从1开始
    Option
        var b: Option[String] = Some("hello")
        b.getOrElse("default")
        b.get
        b.isEmpty
Unit
	singleton   
	var a = ()

Extractor
Object
Companion Object

Expression
    Expressions are computable statements.

Values
	val myVal 
Variables
	var myVar
Block
    expressions with {}
	block的值为最后一条表达式的值

Object
	singleton class的实例

类型推断(type inference)
    var myVar: Int = 10
    var myVal = 'test'


Case class
    默认拥有apply(), 无需new可新建实例
    默认有unapply(), 可以进行pattern matching
    参数自动为val, 可以有默认值
    objcet都是Serializable
    可以使用==进行相等比较, 使用数据而不是引用
    默认有copy()可以进行拷贝

With
    使用mixin(trait)来构造类
    一个类只能从一个类或trait继承(extends), 其他的都要使用with

Trait
    类似于java8的interface, 可以有静态属性和默认实现


Functions
    Functions are expressions that take parameters.

Methods
    使用def进行定义
	默认返回最后一条表达式的值
	如果不接受参数, 调用时可以省略括号
	返回类型可以省略, 为Unit类型
    如果有return语句, 则返回类型不可省略

    // method body仅为一条语句
    def add(x:Int, y:Int):Int = x + y

    def add(x:Int, y:Int):String = {
        val r = x + y
        r.toString
    }
    //返回值类型可省略
    def add(x:Int, y:Int) = {
        println(x + y)
    }

    //无参数
    def name:String = System.getProperty("user.name")
    
        
Sealed Class
    子类型必须在同一个文件声明

命名形参
    def add(first: => Int) = {println(first)}
形参默认值
    def add(x: Int = 10)

命名实参
    def printName(firstName: String, lastName:String){println(firstName + lastName)}
    printName(firstName = 'bob', lastName = 'TT') //关键字传值调用
    printName('bob', 'TT')

类的构造函数
	class Pizza {

	  var crustSize = 12
	  var crustType = "Thin"
	  
	  def this(crustSize: Int) {
		this()
		this.crustSize = crustSize
	  }

	  def this(crustSize: Int, crustType: String) {
		this(crustSize)
		this.crustType = crustType
	  }

	  override def toString = {
		"A %s inch pizza with %s crust.".format(crustSize, crustType)
	  }

	}

    class Person(name:String){} # 主构造函数

获取变量类型
	a.getClass().getSimpleName()

Generic method
	def f[T](x:T):T = x;

For comprehensions
	var a = for (x <- Seq(1, 2, 3) if x > 2) yield x

import 
	import users._  // import everything from the users package
	import users.User  // import the class User
	import users.{User, UserPreferences}  // Only imports selected members
	import users.{UserPreferences => UPrefs}  // import and rename for convenience

字符串插值
    s插值器
        var name = "bob"
        var msg = s"hello $name"
        var msg = s"p1 ${p1 == p2}"  //表达式
    f插值器(类似于printf)
		val height=1.9d
		val name="James"
		println(f"$name%s is $height%2.2f meters tall")//James is 1.90 meters tall 
    raw插值器
		val str = raw"a\nb" \n不会被处理成换行

Range
    1 to 3 
    1 to 10 by 2
    1 until 3 (不包含3)
    Range(0, 10)
    Range(0, 10, 2)

App
    object Main extends App
    args: List[String]
    DelayedInit trait


读取标准输入
    val line = Console.readLine

读取文件
     Source.fromFile("test.txt" ).foreach{ 
         print 
      }
写入文件
      val writer = new PrintWriter(new File("test.txt" ))
      writer.write("Hello Scala")
      writer.close()
函数柯里化
	原函数
		def add(x:Int,y:Int)=x+y
	变形
		def add(x:Int)(y:Int)= x + y 
	相当于
		def add(x:Int) = (y:Int) => x + y

编译
    > scalac Main.scala Point.scala
    > scala -classpath . Main

REPL
    :type <reference> # 获取类型

Tuple1-22 Function1-22

Function
    
    function也是一种对象,每个对象都是scala.Function1-22的对象
    函数对象的调用
        val f = (x:Int) => x + 1
        f.apply(3) 
    f(3) 避免使用apply, 直接使用类method的调用方式
    例子
        List.apply(1, 2, 3) 也可以直接通过 List(1, 2, 3) 创建一个List实例.

    function是匿名函数, 不用def进行声明
        var add = (x:Int)=>x + 1
        val getAnswer = () => 100

Pattern Matching

用户输入
    import scala.io.StdIn._
    readLine
    readInt

import
    import scala.math  // math.abs()
    import scala.math._  //导入全部, 使用时无需package名
    import java.util.{Random, regex} //导入部分
    import java.util.{Random=>MyRandom, regex} //重命名

类型转换
    var a = 'c'
    var b: Int = a
    a.toInt 

Underscore
    function placeholder
        val z = Array(1, 2, 3)
        z.map(_ * 10)
        z.reduce( _ + _ )
    
Tips
    java.lang 默认被导入
    var a = BigInt(1231238098)
    var b = BigDecimal(12.31238098)
    import scala.math._
        abs
        ceil
        floor
        max
        min
        random
        round
        pow
    for(i <- 1 to 5; j <- 6 to 10) //嵌套循环, 第一部分在外层, 第二部分在内层

    printf("number is %d\n", 10)
    print("string")

    任意变量与字符串相加, 结果为字符串
    Char必须使用单引号, Char可以当成Int来使用
    如果method不接受参数, 定义时()可选, 不带(), 则调用时不能带(), 有()则均可以

    variable.getClass.getSimpleName

    List不可变, Array可变
    Seq()返回List
   
    //保留两位小数
    val a = 3.1415926
    val b =  a.formatted("%.2f")

    groupBy(identity)

    函数传值为call by value
    scala没有static关键词, 使用object来替代
    eq检查引用, ==检查值



