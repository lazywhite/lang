数据类型
    Byte
    Short
    Int
    Long
    Boolean
    Char
    Float
    Double
    String
    Unit
    Null
    Nothing
    Any
    AnyRef

常用数据类型
	Map
		var a:Map[String, Any] = Map("key" -> "value")
		a.keys
		a.values
        a.iterator	
	Set
		var a:Set[Any] = Set(1, 20)
		a.toList
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
    Array
        var x: Array[Any] = new Array[Any](3)
        x(0) = 'c'
        var z = Array(1, 2, 3) # 默认就是Any
        
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
	return type可以省略, 为Unit类型

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

Seq

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

Tips
    java.lang 默认被导入


