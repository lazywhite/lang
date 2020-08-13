## Introduction
静态强类型， 编译型， 并发型， 自动垃圾回收   
  
1. no support for type inherience
2. no support for method or operator overloading
3. no support for circular dependencies among packages
4. no support for pointer arithmetic
5. no support for assertion
6. no support for generic programming
7. support for type inference \(short assignment\)
8. compilation is fast
9. conciseness simplicity and safety
10. support for interface and type embedding
11. production of statically linked native binaries without external dependency

## Keyword
```
variable
function
receiver
defer
interface
array
slice
map
struct
pointer
channel
range

recursion
type casting
error handling
```
## Keywords
```
break        default      func         interface    select case         defer        go           map          struct
chan         else         goto         package      switch
const        fallthrough  if           range        type
continue     for          import       return       var
```
## Triple dot
```
1.  go list ./...   in any folder lists all the packages, including packages of the standard library first followed by external libraries in your go workspace.
2.  a := make([]int, 500)    
SomeVariadicFunc(a...)  unpacking "a" as the arguments to a function
3.  b := [...]int{1,2,3}  "..." is evaluated to size of array in compile time
4. SomeVariadicFunc(a ...int)  define a variadic function
```  
## Format output
```
%v: the value in a default format
%+v: when printing structs, the plus flag adds field names 
%#v: a go-syntax representation of the value
%T: a go-syntax representation of the type of the value 
%%: a literal percent sign
%t: the word true of false
%b: base 2 
%d: base 10 
%o: base 8 
%c: the character 
%x: base 16, with lower-case letters for a-f
%X: base 16, with upper-case letters for A-F
%U: Unicode format: U+1234; same as "U+%04X"
%f: decimal point but no exponent
%s: the uninterpreted bytes of the string or slice
%q: a double-quoted string safely escaped with Go syntax
%p: base 16 notation, with leading 0x
```

## Topic  
- In Go, a name is exported if it begins with a capital letter  
- When importing a package, you can refer only to its exported names. Any "unexported" names are not accessible from outside the package.  

- an array has fixed size  
- use 'reflect.TypeOf()' to get type of variable
- when using <&struct>.field, the pointer is automatically dereferenced   
- no generic method supported in golang  
- interface implementation is implicit  
- module alias  
- make() to create array, map
- range keyword to iterater over containers like "array" and "map"
- interface{} stand for any type
- import path conflict with standard library will get a  compile error of "redeclaration"
- import . "<pkg>", everything is imported into current namespace
- import _ "<pkg>" solely for side effect, call init() only, a package can have multiple init()
- multi init() in same "go" file 
- compile a package will not recursive
- error handling 
- "goto" keyword
- pointer to array is meaning less, use "slice" instead  
- pointer arthmetic is not supported in Go
- time.Sleep(1 * time.Second)
- calling between Go and C
- testflag, testfunc
- standard library source code in $GOROOT/src
- 交叉编译  CGO_ENABLED=0 GOOS=linux|darwin|windows GOARCH=amd64 
- 字符串插值, 使用text/template
- io/ioutil 
- flag, os.Args
- fallthrough: no break and execute next case forcefully
- Maps are reference types, so they are allways passed by reference. You don't need a pointer.
- A "go" statement starts the execution of a function call as an independent concurrent thread of control, or goroutine, within the same address space. 
- TOML: Tom's Obvious, Minimal Language
- getopt
- struct  only fields starting with a capital letter are exported
- struct field tag `json:name,bson:bname`
- string concate
- log package
- type rune: just like "int32", is used to distinguish charactor value from integer, when fmt.Println(m rune), it always output a number, m can be a char
- better not use global variable, hard to test
- do anything in goroutine and return the value over the channel
- import "path/mod"  "package <name>" can be different from file name "mod"
- passing struct pointer as arguments
- godoc <module> <function>
- Lexical tokens are enclosed in double quotes "" or back quotes ``, back quote can not be escaped  
- import  "module",  every "init() of Go file" under that directory is called, without "sub_directories"
- error handling in Go, "error" type
- "* \<type>" define a pointer to "\<type>" , "&\<var>" get the pointer of <var>
- "regexp" module
- "strconv" conversions to and from "string" between "other data types"
- import "os/exec"; exec.Command("")
- "uintptr" type is an integer type that is large enough to hold the bit pattern of any pointer  
- "label" and "goto"
- no "interpreter" interface in go
- "GOPATH"  just like "PATH", you can have a list of "GOPATH"
- append(), cap(), delete(), len(), panic()
- when multiply different type of data, you should convert them to same type firstly
- if you use same rand.Seed(<number>), you will get a same rand.Intn(<number>)
- named return value, use return variable in function and just return
- short assignment is not available outside "func" body
- zero value: 0 for numeric types, false for boolean type and "" for string, "nil" for slice, "nil" for map
- when declaring a const, type could be omitted
- you cannot define a function inside a function in Go
- slice could contain any type, include other slices
- when iterate container by "range" you can skip the index or value by assigning it to "_"
- main() of a program is called by 'runtime.main'  
- type assertion  <var>.(<type>), <var> should be an "interface" variable
- no fork() in golang, because there are other way to do it  

- 无需使用;号
- string使用双引号, 字符使用单引号

## Note
```
var可声明多个变量, 自带类型推断
    var c, python, java bool
    var a = 100
没赋值的var有默认值    
    int 0
    bool false
    string ""
Type(var) 强制类型转换

常量无法使用:=赋值
for的初始化和后置语句可以省略
    for ; sum < 100; {}
    此时分号可以省略, 类似于其他语言的while
    for sum < 100{}
    for{} 死循环
switch的case自带break， 除非手动使用fallthrough语句

defer将函数推迟到外层函数返回后执行
defer推迟的函数被压入到一个栈中， 后进先出
go有指针， 但没有指针运算
通过结构体指针访问成员变量, 取地址符号可省略
    p := &v
    *p.x 等价于 p.x
通过双赋值监测map的key是否存在
    elem, ok := hash["key"]
    不存在ok为false, elem为零值
结构体的方法只是一个带接收者的普通func
函数可以返回任意数量的返回值
函数的返回值可命名, 并被视作定义在函数顶部的变量
声明没有初始值的变量需要类型, 有初始值的变量可以省略类型
switch语句可以省略条件, 用于替代多分枝if-else
切片相当于数据库视图

匿名函数
    func(){
        fmt.Println("this is {b}")
    }()

make([]int, 5) 创建一个数组并返回切片
make(map[string]int)

为结构体定义的方法必须跟结构体在同一个包内
不能为内建类型或其他包内的结构体定义接受者方法


b.(type)用在switch语句的类型匹配中
b.(string) 类型推断, 表示检查b类型是否为string

ch := make(chan int) 创建一个信道, 没有缓冲区
ch := make(chan int, 100) 缓冲区100, 如果缓冲区满发送时才会阻塞, 如果缓冲区空接收时才会阻塞

channel的类型 (单向和双向)
    chan T          // 可以接收和发送类型为 T 的数据
    chan<- float64  // 只可以用来发送 float64 类型的数据
    <-chan int      // 只可以用来接收 int 类型的数据

v, ok := <-ch   # 从信道读取一个值
for i := range c # 不断从信道读取值
close(c) # 关闭一个channel


同一个package内的go file可以直接使用其他go file内部的定义, 并且小写开头的也可以
import pkg, 则可通过pkg.xx访问pkg文件夹下所有go file定义的可导出内容(不包括子文件夹)
import pkg会执行pkg文件夹下所有go file的init()(不包括子文件夹)

双引号的字符串不允许有换行, 反引号可以有
单引号只能用来表示rune类型

c := map[string]int{
    "good": 10,
}
if v, ok := c["good"]; v>1 && ok {
    fmt.Println("kajf")
}

err.Error() # 返回error的string信息

直接在func,package上面写注释, 与声明不要有空行, 则godoc能自动识别

slice = append(slice, elem1, elem2, ...)
slice = append(slice, anotherSlice...)


go build -mod=vendor  main.go  //指定module引用path

go build -mod=readonly main.go //忽略当前目录下的vendor包

go clean -modcache

go mod tidy 并不会更新go.mod,  go mod vendor或者go build, 才会更新go.mod

```
