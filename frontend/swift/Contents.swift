// 常量, 无法改变
let mm: Float = 4
// 变量
var label: String = "The label is "
var len = String(40)
let width = 4


// 强制类型转换
print(label + String(width))

// 变量替换
print("I have \(width) apples")

// 类型别名
typealias Feet =  Int
var x: Feet = 7
print(x)


// 断言
var age = -3
//assert(age > 0, "Age of person can not be less than zero")


// 元组
let http404Error = (404, "Not Found")

let (status, msg) = http404Error

print(http404Error.0)

// 运算符
/*
    一目: 
        前置:  !
        后置:  ++
    双目:  +, -
    三目: a?b:c

*/
// Char
let dog: Character = "D"

// Set
var emptySet = Set<Int>()
emptySet.insert(100)


var testSet: Set<String> = ["hello", "world"]


// optional value: either contain a value or contains 'nil'
// if let name = optionalName  (if optionalName is nil, will return false)

// if define an optional variable without providing a default value
// the variable value is set to nil as default
/* if statement and forced unwrapping */
// if optionVar != nil{
//    print("optionalVar value is \(optionalVal!)")
// }
//

/* optional binding
    if let constName = optionalVar{ 
        statement
    }
*/

// Type inference
// Array

var emptyArray = [Int]()


var numbers = [0,5,3,4]
numbers.sortInPlace()
// array count
numbers.maxElement()
numbers.minElement()
// length
numbers.count


var shoplist = ["catfish", "water", "tulips", "blue paint"]

print(shoplist[0])


// Dictionary
var emptyDict = [String: Float]()
emptyDict["k1"] = 0.23


var occupation = [
    "k1": "val1",
    "k2": "val2"
]

var mn = (10, 20, 30)
print(_stdlib_getDemangledTypeName(mn))

print(occupation["k1"])
occupation["k3"] = String(100)


for (key, value) in occupation{
    print(key)
    print(value)
}

let individualScore = [100, 200, 3990, 1001]
var total = 0
for score in individualScore{
    if score   > 500 {
        total += score
    }
}



// Optional variables
var op_string :String? = "bob"

var greeting = "hello"

if let name = op_string {
    greeting = "hello \(name)"
}
print(op_string!)


// 区间
var start = 0, end = 10
for index in start...end {
    print(index)
}
// 半闭区间

for i in 0..<10{
    print(i)
}

// While loop
var n = 2
while n < 100 {
    print(n)
    n = n * 2
}

// Repeat-while loop
var m = 2
repeat {
    m *= 2
} while m < 100

// for i in range

for var iMMM = 1; iMMM<10; iMMM++ {
    print("lakdjfa;j")
}

// ------------------
// Function definations, argument notation and return type
func greeting (name: String, day: String) -> String{
    return "hello \(name), today is \(day)"
}


// function can return a tuple
func get_prices() -> (Double, Double, Double) {
    return (0.13, 2.42, 6.25)

}


// “variable number of arguments”


func sumOf(numbers: Int...) -> Int{
    var sum = 0
    for number in numbers {
        sum += number
    }
    return sum
}
sumOf(90, 100, 400)



// function in function
func fifteen() -> Int {
    var x:Int = 6
    func add(number:Int) -> Int{
        return number + 9
    }
    add(x)
    return x
    
}
fifteen()


// return a function

func make_incre() -> (Int -> Int){
    func addOne(number: Int) -> Int{
        return number + 1
    }
    return addOne
}


var incre = make_incre()
incre(8)


// function as argument
func hasAnyMatch(list: [Int], condition: (Int -> Bool)) -> Bool{
    for item in list{
        if condition(item){
            return true
        }
    }
    return false
}
func biggerThanFive(number: Int) -> Bool{
    if number > 5 {
        return true
    }
    else{
        return false
    }
}


// hasAnyMatch(numbers, condition: biggerThanFive)

// anonymous function
({(name: Int) -> Int in
        return name * 3
})(10)




// fallthrough of Switch
var scores = 0
var key = 0

switch key {
case 0:
    scores += 10
    fallthrough
default:
    scores += 20
}

// subscript : sequential object like array or dictionary

struct Container{
    let allAttr = ["one", "two", "three"]
    subscript(index: Int) -> String{
        get {
            return allAttr[index]
        }
        set(newValue){
            
        }
    }
}

var ctn = Container()
ctn[1]


// struct are value type,
// classes are reference type, all reference point to same object
/*


Both Classes and Structures can do below

    Define properties to store values
    Define methods to provide functionality
    Be extended
    Conform to protocols
    Define intializers
    Define Subscripts to provide access to their variables


CLASS can only do below

    Inheritance
    Type casting
    Define deinitialisers
    Allow reference counting for multiple references.

*/


// --------------
// class defination
class Shape {
  
    var length: Int = 0
    init(num: Int){
        self.length = num
    }

    func simpleDescription() -> String{
        return "This is the description, \(self.length)"
    }
 
}


class Circle: Shape {
    var len: Int = 0
    var PI: Double = 3.14
    var name: String = ""

    /* 
    1.设置子类声明的属性值
    2. 调用父类的构造器
    3. 改变父类定义的属性值。其他的工作比如调用方法、getters 和 setters 也可以在这个阶段完成。
    */
    init(len: Int, name: String){  //构造函数
        // super class init must be called
        super.init(num: len)
        self.len = len
        self.name = name
    }
    deinit{} //析构函数, 不允许有参数
    func complexDes() -> String{
        return "Complex description , \(self.len, self.name)"
    }
    // Property, getter and setter
    var size: Double {
        get{
            return Double(self.len * 2) * PI
        }
  
    }
    // override function of super class
    override func simpleDescription() -> String {
        return "hehe, this function is overrided"
    }
}
// argument label must be carried
var c = Circle(len:10, name:"circle")
c.length
c.complexDes()
c.simpleDescription()
c.size

// no multi inheritance allowd in swift

// willSet: execute before property is setted
// didSet: executed after property is setted


// protocol, class enumeration struct can all adopt protocol
protocol ExampleProtocol {
    var simpleDescription: String {get}
    mutating func adjust()
}



class SimpleClass: ExampleProtocol {
    var simpleDescription: String = "A simple Class"
    var anotherProperty: Int = 100
    func adjust() {
        simpleDescription += " but realized protocol"
    }
}

var a = SimpleClass()
a.adjust()
a.simpleDescription


struct SimpleStruct: ExampleProtocol{
    var simpleDescription: String = "A simple structure"
    mutating func adjust(){
        simpleDescription += " realized protocol"
    }
}

var b = SimpleStruct()
b.simpleDescription
b.adjust()
b.simpleDescription

//extension

extension Int: ExampleProtocol{
    var simpleDescription: String{
        return "the number \(self)"
    }
    mutating func adjust(){
        
    }
}

7.simpleDescription

extension SimpleStruct{
    var addProperty: String{
        return "additional property"
    }
}

b.addProperty


// Generic
func repeatItem<Item>(item:Item, times: Int) -> [Item]{
    var result = [Item]()
    for _ in 0..<times{
        result.append(item)
    }
    return result
}
repeatItem("hello", times: 3)
repeatItem(10, times: 3)

// enumeration
// rawValue is immutable
enum NetStat{
    case Unknown
    case Connecting(Int, String)
    case Connected
    case Disconnected
    
    init(){
        self = .Unknown
    }
}

var conn = NetStat()
conn = .Connecting(3306, "127.0.0.1")



// self defined error type
enum MyError: ErrorType{
    case UserError
    case NetworkError
    case DiscoveryError
}

func doStuff() throws -> String{
    print("do stuff 1")
    print("do stuff 2")
    throw MyError.NetworkError
     // code after throw will never be executed
}

do{
    try doStuff()
    print("Success")
}catch MyError.NetworkError{
    print("network error occured")
}catch {
    print("An Error occured")
}



// type cast

class MediaItem{
    var name: String
    init(name: String) {
        self.name = name
    }
}

class MovieItem: MediaItem{
    var director: String
    init(name: String, director: String){
        self.director = director
        super.init(name: name)
    }
}

class MusicItem: MediaItem{
    var artist: String
    init(name:String, artist:String){
        self.artist = artist
        super.init(name:name)
    }
}

let library = [
MovieItem(name: "Casablanca", director: "Michael Curtiz"),
MusicItem(name: "Blue Suede Shoes", artist: "Elvis Presley"),
MovieItem(name: "Citizen Kane", director: "Orson Welles"),
MusicItem(name: "The One And Only", artist: "Chesney Hawkes"),
MusicItem(name: "Never Gonna Give You Up", artist: "Rick Astley")
]

// type downcast
for obj in library{
    if let item = obj as? MovieItem {
        print("Movie gotted")
    }else if let item = obj as? MusicItem{
        print("Music gotted")
    }

}
// ============


// optional chaining

// nested type


/* ARC: automatic reference counting
    whenever you assign a class instance to a property, constant, or
    variable,that property, constant, or variable makes a strong 
    reference to the instance
*/


/*
Class definitions can have at most one deinitializer per class.
The deinitializer does not take any parameters and is written 
without parentheses
*/
