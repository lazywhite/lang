## 安装
```
docker pull swift

# 需要开特权, 否则无法启动REPL
alias run_swift="docker run --rm -it --privileged -v /root/swift-code:/code swift /bin/bash"
```

## 使用
```
mkdir demo;cd demo
swift package init --type executable # 可执行项目  library: 库项目)
swift build; .build/debug/demo #编译执行  
# after update dependencies
swift package update
```
## Tips
```
keyword
    Void
    Any
    AnyObject
    as
    is
    typealias

datatype
    Int
    Float
    Double
    String
    Bool
collection type
    Tuple
    Set
    Array
    Dictionary
optional type
    var some1: String?  # 如果没有初始化， 则默认为nil
    if some1 != nil{
        print("value is \(some1!)") # force unwrapping
    }

    var a = Optional("hello") // a is String? 
optional binding
    var some2: Int? = 100
    if [let|var] mySome = Int(some2){
        print("value is \(mySome)")
    }else{
        print("nil value")
    }
implicitly unwrapped optional
    初始化后一定会有值，无需在每次访问都用！进行解封, 如果有nil值，则runtime error
    var some3:String? = "optional string"
    let mySome = some3!
    var some4:String! = "implicitly unwrapped optional string"
    let mySome = some4 
    仍然属于optional， 可以使用if test
    if some4 != nil {}

error handling
    func canThrowError() throws{ //声明有可能抛出错误的函数
    }
    func canThrowError() throws -> Int{ //声明带返回值的有可能抛出错误的函数
    }
    do{
        try canThrowError()
    }catch{
    }

assertion and precondition
    Assertions and preconditions are checks that happen at runtime
    Assertions help you find mistakes and incorrect assumptions during development, and preconditions help you detect issues in production.
    there’s no way to catch a failed assertion.
    Assertions are checked only in debug builds, but preconditions are checked in both debug and production builds.
    var a = 10
    assert(a > 0, "age can't be less than zero")
    assert(a > 0) 省略assertion message
    assertionFailure("message") 主动抛出assertion error

    precondition(index > 0, "index must be greeter than zero")
    preconditionFailure("failer message")
string interpolation
print(var1, var2, separator: ",", terminator: "\n")
comment
    //
    /* */
    nested multiline comment

三元运算
    let a = true
    let b = a ? 100 : 200  //标点必须有前后空格
range
    1...5 闭区间
    1..<5 右开区间
    one side range
        names[2...]
        names[...2]
        names[2..<]

String
    var a = String()
    var a = ""
    a.isEmpty
Array
    let names = ["alice", "bob"]
    names.count
    for (index, name) in names.enumerated(){}
    for name in names {}

Set
    var a = Set<String>()
    var a: Set = ["alice", "bob"]

Dictionary
    var myHash = [String: String]()
    var myHash = ["key": "value"]
    var myHash: [String: String] = ["key": "value"]

Structure & Class
    相同点
        定义属性
        定义方法
        定义subscript
        构造器
        使用extention
        遵守protocol
    class独有
        允许集成
        type casting
        析构器
        引用计数
        
构造与析构
    构造器不是函数, 接受参数列表, 需要写小括号
    析构器
        不是函数, 并且不接受参数, 没有小括号
        子类实例被回收时, 父类的析构总会被调用

Struct
    省略init()
        1. 在别的module无法调用, 需要有public init()
        2. 具备默认成员初始化器
            Struct Resolution{
                var width = 0
                var height = 0
            }
            let r = Resolution(width: 100, height: 200)//必须全部初始化
    mutate 
        
Access Control
    open
        无法修饰struct
        open class: 可以在任何地方被继承
        open class member: 可以在任何地方被overriden
    public
        public class: 仅能在内部module被继承
        public class member: 仅能在内部module被overriden

    internal
        仅在定义的module内部访问, 无法在其他module访问
    fileprivate
        仅在entity定义的文件内部可访问
    private
        仅在entity自身的定义内部访问

Automatic Reference Counting
    仅对class instance起作用,  Structures, enumerations是值类型, 不是引用类型, 类实例才是引用类型
    仅当指向class instance的引用计数为0时才进行回收, 调用deinit


Any & AnyObject
    Any can represent an instance of any type at all, including function types and optional types.
    AnyObject can represent an instance of any class type.

    var a: [AnyObject] = ["bob", 1, aInstance] // wrong
    var a: [AnyObject] = [aInstance, bInstance] // right
    var a: [Any] = ["bob", 1, aInstance] // right

函数参数传递
    值类型
        number
        String
        Struct
        Enum
    引用类型
        class instance
    值类型默认是let copy, 在函数内部无法更改

    值类型使用inout修饰, 可以达到修改目的
        var a = 10
        func myFunc(mem: inout Int){ mem = 100 }
        myFunc(&a)  //传递a的引用
    引用类型默认即可修改

鉴定引用是否相同
    ===
    !==
鉴定值类型是否相同
    ==
    !=

Property
    stored property(属于实例)
        class, struct可具备
        lazy property(只能修饰变量), 仅当第一次访问时计算
    computed property(属于实例)
        enum, class, struct可具备
        newValue(setter简写)
        readonly (仅有getter)
        不能有默认值
    type property(属于类型)
        使用static修饰
    property observer
        适用对象
            非lazy的stored property
            global variable 
            local variable
            type property
        willSet在属性更改前调用
            newValue
        didSet在属性更改后调用
            oldValue
Methods
    mutating method
		struct Point {
			var x = 0.0, y = 0.0
			mutating func moveBy(x deltaX: Double, y deltaY: Double) {
				self = Point(x: x + deltaX, y: y + deltaY)
			}
		}
	type method
		static func
			self指type本身, 不是instance

Func
    argument label
        func test(label amount: Int){}
        test(label: 100)
    default parameter value
        func t(name: String, age: Int=0){}
    变长参数
        func t(_ num:Double...)
    function type
        func addTwoInts(_ a: Int,_ b: Int) -> Int{}
        var mathFunc: (Int, Int) -> Int = addTwoInts
        可在func中作为参数类型及返回值类型
    nested function

Subscript
	使class, structure, enum可以使用 entity[index]的方式访问成员
	readonly subscript
		struct ThreeTable{
			let multiplier = 3
			subscript(index:Int)->Int{
				return multiplier * index
			}
		}

		struct Matrix{    
			var rows = [1, 2, 3]    
			var cols = [4, 5, 6]    
			subscript(row:Int, col:Int) -> Int{    
				return rows[row] * cols[col]    
			}    
		}    
		let m = Matrix()    
   		print(m[1, 2]) //多个参数作为下标   

	read-write subscript
		struct Proxy{
			var data = [2, 4, 6]
			subscript(index: Int) -> Int{
				get{
					return data[index] / 2
				}
				set{
					data[index] = newValue * 2
				}
			}
		}

class继承
    stored property, computed property, subscript, property observer均可继承, override
    重写需要用override修饰
    不允许重写需要用final修饰
    不允许多重继承
    
class 初始化
	如果property没有默认值, 则必须定义init()进行初始化
	如果property全部有默认值或optional, 则init()可省略
    如果父类有init(), 子类需要在init()内部先初始化独有属性, 最后调用super.init()

    委托初始化
        struct, enum 无法继承, 因此只能调用自身其他的init()
        class可以调用自己及父类的init()

    designated init() 主初始化
    convenience init() 辅助初始化, 最终调用主初始化, 可提供默认初始化值
    required init()
        required修饰符只能用于修饰类初始化方法。
        当子类含有异于父类的初始化方法时（初始化方法参数类型和数量异于父类），子类必须要实现父类的required初始化方法，并且也要使用required修饰符而不是override。
        当子类没有初始化方法时，可以不用实现父类的required初始化方法。

optional chaining
	if let johnsStreet = john.residence?.address?.street {
		print("John's street name is \(johnsStreet).")
	} else {
		print("Unable to retrieve the address.")
	}

泛型
    Generic function
        func swap(_ a: inout Int, _ b: inout Int){}
        func swap<T>(_ a: inout T, _ b: inout T){}
    generic struct
    Type Constraint
    Associated Types
    Generic Where Clauses
    Generic Subscripts
type cast
	仅适用于class
	downcasting
		as? 返回Optional
		as! 失败触发runtime-error
Extension
	适用于class, struct, enum, protocol	
	作用
		computed type property, computed instance property
		instance method, type method
		new initializer
		subscript
		define and use nested types
		making existing type comform to protocol
     
mutating function
    适用于enum, struct
    意义
        用于immutable value type改变自身property

Protocol
    可以被struct, enum, class 遵守
    包含method, property, mutating func, init()
    遵守者无需override
    可以多重继承其他协议
    继承于AnyObject的protocol, 仅能被class conform
    protocol也是一种type
    Protocol Composition: 将多个protocol
        typealias NamedAgedObject = Named & Aged (或)
        struct Student: Named, Aged{} (与)


内存安全
    变量使用前被初始化
    内存被回收后无法被访问
    array index越界会触发out-of-bounds error
    对同一块内存的并发访问不会冲突

SPM
    使用swift package将多个swift文件打包成module
    module member使用open, public, internal, fileprivate, private修饰
    import Bar; Bar.member
    swift package clean # 清理构建
    swift package update # 更新依赖
    git ci --amend后， 需要重新打tag，并且更新Package.swift以来的tag号
    swift build # 编译打包

    let packge = Package(
        name: "Foo",
        dependencies:[
            .package(url: "/code/Bar", from: "1.0.10"),    //本地repo
            .package(url: "https://github.com/foo/bar", from: "1.0.10"), //远程repo
        ]
    )

    let package = Package(
        name: "Bar",
        products: [
            .library(
                name: "Bar",
                targets: ["Bar"]),  //规定包含的目标, 默认为Sources/Bar, 此目录外的默认不包含
        ]
    )
```
