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
numbers.sort()
// array count
numbers.max()
numbers.min()
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
//print(_stdlib_getDemangledTypeName(mn))

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
var op_string :String? = ""

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



// function in function



// return a function

func make_incre() -> ((Int) -> Int){
    func addOne(number: Int) -> Int{
        return number + 1
    }
    return addOne
}


var incre = make_incre()
incre(8)


// function as argument
func hasAnyMatch(list: [Int], condition: ((Int) -> Bool)) -> Bool{
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


hasAnyMatch(numbers, condition: biggerThanFive)

// anonymous function
({(name: Int) -> Int in
        return name * 3
})(10)


//function default parameter values
func greet(name: String, msg :String = "hello "){
    print(msg, name)
}

greet(name: "bob")

//ignore function return value
func test() -> Int {
    return 10
}
let _ = test()

//ommiting argument labels
func printNum(_ a:Int){
    print(a)
}
printNum(10)


//In-Out parameter

func swapNum(_ a: inout Int, _ b: inout Int){
    let temp = a 
    a = b 
    b = temp
}
var numA = 3 
var numB = 107 

print("before: a: \(numA), b:\(numB)")
swapNum(&numA, &numB)
print("before: a: \(numA), b:\(numB)")


// nested function
func outside(a:Int)->Int{
    func inside(a:Int)->Int{
        return a + 1
    }
    return inside(a: a)
}
print(outside(a: 100))


//-------------------------------------

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


// class enumeration struct can all adopt protocol
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

/*
struct Resolution{
    var width = 0
    var height = 0
}


class VideoMode{
    var resolution = Resolution()
    var frameRate = 0.0
    var name: String?
    init(_ name: String?){
        self.name = name
        print("instance inited..")
    }
    deinit{
        print("instance deinited...")
    }
}

class Test{
    lazy var video = VideoMode(Optional("test"))
    var mount = 10
    static var age = 10 {
        willSet{
            print(newValue)
        }
        didSet{
            print(oldValue)
        }

    }
    var name: String = "" {
        willSet{
            print(newValue)
        }
        didSet{
            print(oldValue)
        }

    }
    func greet(){
        print("hehe")
    }
    func incre(hehe amount: Int){
        self.mount += amount
    }
}



struct Proxy{
    var data = [2, 4, 6]
    subscript (index:Int)->Int{
        get{
            return data[index] / 2
        }
        set{
            print(newValue)
            data[index] = newValue * 2

        }
    }
}
struct Matrix{
    var rows = [1, 2, 3]
    var cols = [4, 5, 6]
    subscript(row:Int, col:Int) -> Int{
        return rows[row] * cols[col]
    }
}
let t = Matrix()
print(t[1, 2])
*/

/* class Inherience

class Father{
    var name: String
    let lastName = "Delin"
    init(name: String){
        self.name = name
    }
    var fullName:String{
        return self.name + self.lastName
    }
    subscript(index: String) -> Bool{
        return self.name.hasPrefix(index)
    }
    func greet(){
        print("I'm a father")
    }
    final func say(){
        print("My family is \(self.lastName)")
    }
}
class Child:Father{
    var age: Int?
    init(name: String, age: Int){
        self.age = age
        super.init(name:name)
    }
    override func greet(){
        print("I'm a child")
    }
}
let c = Child(name:"bob", age: 10)
print(c.fullName)
print(c["b"])
c.greet()
c.say()
c.name = "alice"

extension Double{
	var m:Double{
        return self

	}
    var km: Double{
        return self * 1000.0
    }
    var mm: Double{
        return self / 1_000.0
    }
}
let f = 30.km
print(f)


extension Int{
    func repetition(task: () -> Void){
        for _ in 0..<self{
            task()
        }
    }
}
3.repetition{
    print("test")
}

mutating fucntion

enum Color{
    case red, white, blue, none
    mutating func to_none(){
        self = .none
    }
}
var c = Color.white
print(c)
c.to_none()
print(c)
*/


