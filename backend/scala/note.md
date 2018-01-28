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
        列表是不可变的
		var a:List[Any] = List(1, 'c', 'string')
		a.toSet
        a.head(首元素)
        a.tail(除首元素的所有元素)
        a.isEmpty
        a.reverse
        List.tabulate()
        a(2) # 按下标获取元素
    Array
        var x: Array[Any] = new Array[Any](3)
        x(0) = 'c'
        var z = Array(1, 2, 3) # 默认就是Any
        
    Iterator
        while(i.hasNext){println(i.next)}
        i.foreach
    Tuple
        var a = (1, 2, 3)
        a._1 # 按下标访问元素
    Option
        var b: Option[String] = Some("hello")
        b.getOrElse("default")
        b.get
        b.isEmpty
Unit
	singleton   
	var a = ()

Values
	val myVal 
Variables
	var myVar
Block
	{expression list}
	block的值为最后一条表达式的值

Object
	singleton class的实例

类型推断(type inference)
    var myVar: Int = 10
    var myVal = 'test'

匿名函数
    var add = (x:Int)=>x + 1
    add(10)

    val getAnswer = () => 100
    getAnswer()

Functions
    接受参数的表达式
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
        
Sealed Class/Trait
    子类型必须在同一个文件声明

命名形参
    def add(first: => Int) = {println(first)}
形参默认值
    def add(x: Int = 10)

命名实参
    def printName(firstName: String, lastName:String){println(firstName + lastName)}
    printName(firstName = 'bob', lastName = 'TT')
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

字符串插值(s, f, raw)
    var name = "bob"
    var msg = s"hello $name"

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

