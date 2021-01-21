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

## Keywords
```
break        default      func         interface    select case         defer        go           map          struct
chan         else         goto         package      switch
const        fallthrough  if           range        type
continue     for          import       return       var
```
## 基本数据类型
```
uint
uint8
uint16
uint32
uint64
int
int8
int16
int32
int64
float32
float64
complex64
complex128
rune
byte
uintptr

string
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
- interface{} stand for any type
- import path conflict with standard library will get a  compile error of "redeclaration"
- import <new> "github.com/user/repo" module alias  
- import . "<pkg>", everything is imported into current namespace
- import _ "<pkg>" solely for side effect, call init() only, a package can have multiple init()
- 一个file有多个init(), 按声明顺序执行, 一个package有多个file的init(), 如果有依赖关系，按依赖智能执行
- import package时, 会先执行所有的变量结构体声明，再执行init()
- error handling 
- "goto" keyword
- pointer to array is meaning less, use "slice" instead  
- pointer arthmetic is not supported in Go
- calling between Go and C
- testflag, testfunc
- 标准库代码位置: $GOROOT/src
- 交叉编译  CGO_ENABLED=0 GOOS=linux|darwin|windows GOARCH=amd64 
- fallthrough: switch case自动break, 用此关键字可不break
- Maps are reference types, so they are allways passed by reference. You don't need a pointer.
- A "go" statement starts the execution of a function call as an independent concurrent thread of control, or goroutine, within the same address space. 
- TOML: Tom's Obvious, Minimal Language
- getopt
- struct  only fields starting with a capital letter are exported
- struct field tag `json:name,bson:bname`
- log package
- type rune: just like "int32", is used to distinguish charactor value from integer, when fmt.Println(m rune), it always output a number, m can be a char
- better not use global variable, hard to test
- do anything in goroutine and return the value over the channel
- import "path/mod"  "package <name>" can be different from dir name "mod"
- passing struct pointer as arguments
- godoc <module> <function>
- Lexical tokens are enclosed in double quotes "" or back quotes ``, back quote can not be escaped  
- import  "module",  every "init() of Go file" under that directory is called, without "sub_directories"
- "*\<type>" define a pointer to "\<type>" , "&\<var>" get the pointer of <var>
- "regexp" module
- "strconv" conversions to and from "string" between "other data types"
- "uintptr" type is an integer type that is large enough to hold the bit pattern of any pointer  
- "label" and "goto"
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
- string使用双引号, rune使用单引号

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

defer将函数推迟到外层函数返回前执行
defer推迟的函数被压入到一个栈中， 后进先出
go有指针， 但没有指针运算
通过结构体指针访问成员变量, 取地址符号可省略
    p := &v
    *p.x 等价于 p.x



结构体的方法只是一个带接收者的普通func
函数可以返回任意数量的返回值
函数的返回值可命名, 并被视作定义在函数顶部的变量, 只需return,不需要写返回值变量名称
声明没有初始值的变量需要类型, 有初始值的变量可以省略类型
switch语句可以省略条件, 用于替代多分枝if-else
切片相当于数据库视图

匿名函数
    func(){
        fmt.Println("this is {b}")
    }()

array,slice
    make([]int, 5) 创建一个数组并返回切片

map
    初始化
        var m map[string]int
        var n = make(map[string]int)
        n := map[string]int{}
        n := map[string]int{"key1": 100}
    删除key
        delete(n, "key1")
    遍历
        for k,v := range n{}

    通过双赋值监测map的key是否存在
        elem, ok := hash["key"]
        不存在ok为false
        elem = hash["key"], 如果没有key，则返回类型0值

为结构体定义的方法必须跟结构体在同一个包内
不能为内建类型或其他包内的结构体定义接受者方法


b.(type)用在switch语句的类型匹配中, 固定用法，表示对b的类型进行switch case匹配
b.(string) 类型推断, 表示检查b类型是否为string

    a := map[string]interface{}{
        "key": 100
    }
    if v, ok := a["key"];ok{   // 是否包含key
        if v2, ok := v.(int); ok{ //类型是否为int
            fmt.Println(v2)
        }
    }

ch := make(chan int) 创建一个信道, 没有缓冲区
ch := make(chan int, 100) 缓冲区100, 如果缓冲区满发送时才会阻塞, 如果缓冲区空接收时才会阻塞
close(chan)

channel的类型 (单向和双向)
    chan T          // 可以接收和发送类型为 T 的数据
    chan<- float64  // 只可以用来发送 float64 类型的数据
    <-chan int      // 只可以用来接收 int 类型的数据

v, ok := <-ch   # 从信道读取一个值
ch <- 5 # 往信道发送一个值
for i := range c # 不断从信道读取值
close(c) # 关闭一个channel


同一个package内的go file可以直接使用其他go file内部的定义, 并且小写开头的也可以
import pkg, 则可通过pkg.xx访问pkg文件夹下所有go file定义的可导出内容(不包括子文件夹)
import pkg会执行pkg文件夹下所有go file的init()(不包括子文件夹)

双引号的字符串不允许有换行, 反引号可以有
单引号只能用来表示rune类型


err.Error() # 返回error的string信息

直接在func,package上面写注释, 与声明不要有空行, 则godoc能自动识别

slice = append(slice, elem1, elem2, ...)
slice = append(slice, anotherSlice...)


go mod vendor //将依赖包copy到当前vendor文件夹内
go build -mod=vendor  main.go  //指定依赖module从vendor文件夹搜寻

go build -mod=[readonly|mod] main.go //忽略当前目录下的vendor包

go clean -modcache

go mod tidy 并不会更新go.mod,  go build会

func, method的参数不支持默认值

变长参数
    func add(nums ...int) //nums为array

glog使用
    ./your_application --logtostderr=1
    GLOG_logtostderr=1 ./your_application


go有指针, 默认不支持指针运算, unsafe包可以提供

glide: go依赖管理工具， 已废弃，推荐使用go  module

pointer receiver
    相对应得有value receiver
    https://tour.golang.org/methods/4
    Go does not have classes. However, you can define methods on types.
    A method is a function with a special receiver argument.
    Methods with pointer receivers can modify the value to which the receiver points (as Scale does here). Since methods often need to modify their receiver, pointer receivers are more common than value receivers.

receiver method 只能在相同的package内部定义



格式化代码
    gofmt -w /path/to/*.go
    go fmt /path/to/*.go //go fmt相当于调用gofmt -w -l
    go fmt -n ./pkg/... //必须在go.mod 目录执行
    go fmt ./...

源码检查工具
    go vet ./... 

go run file.go, file.go必须属于package main, 并且定义了main函数, 否则go run无法执行
go build file.go 生成二进制文件

GOROOT为go的安装路径

time.Sleep(1 * time.Second)

字符串插值, 使用text/template
读写系统文件
    不要使用 "io/ioutil", ReadFile, WriteFile有bug

系统文件路径
    import "path/filepath"
    dir, err := filepath.Abs(filepath.Dir(os.Args[0]))

命令行参数
    os.Args
        argWithProg := os.Args
        argWithoutProg := os.Args[1:]

    flag
        var b = flag.Bool("b", false, "bool类型参数")
        var s = flag.String("s", "", "string类型参数")
        flag.Parse()

strings.Join([]string{"hello", "world"}, ",")
strings.Repeate("", 10)
fmt.Sprintln, fmt.Sprintf
执行系统命令
    import "os/exec"
    exec.Command("")

支持递归函数
    func fib(n uint64) uint64{
        if(n < 2){
            return n
        }else{
            return fib(n-1) + fib(n-2)
        }
    }

环境变量
    os.Getenv("FOO")
    os.Setenv("Bar", "100")
    for _, e := range os.Environ() {
        pair := strings.SplitN(e, "=", 2)
        fmt.Println(pair[0])
    }

go不支持继承，但支持embedding, 类型有
	struct in struct
		promote method, field
	interface in interface
	interface in struct


i, err := strconv.Atoi("-42")
s := strconv.Itoa(-42)
b, err := strconv.ParseBool("true")
f, err := strconv.ParseFloat("3.1415", 64)
i, err := strconv.ParseInt("-42", 10, 64)
u, err := strconv.ParseUint("42", 10, 64)

Named Type, Unnamed Type。


byte	字符型，unit8 别名	表示 UTF-8 字符串的单个字节的值，对应 ASCII 码的字符值	
rune	字符型，int32 别名	表示 单个 Unicode 字符
go没有char类型


比较struct，slice，map是否相等
    reflect.DeepEqual(obj1, obj2)


const常量只能是string，number, bool, 不能是map，array，slice

Exit(n) main.go 返回值

panic('error')用来主动触发程序崩溃，会停止执行当前goroutine其它代码，并执行defer函数,  其它原因的崩溃defer不会执行
recover()只能在defer中发挥作用, 终止程序崩溃

defer会在所在函数return前执行，多个defer后进先出

sync.WaitGroup  goroutine同步
wg.Add(n) goroutine计数器加n, 一般每启动一个goroutine wg.Add(1), 每个goroutine调用wg.Done(), 主程序wg.Wait()

函数变长参数, args为一个slice

	func greet(args ...int){
		sum := 0
		for _, v := range args{
			sum += v  // 支持+=
		}   
		fmt.Printf(%d\n", sum)
	}
    greet(1, 2, 3)
    nums = []int{1, 2, 3} //type slice
    greet(nums...) //展开slice

    xx = [...]int{1, 2, 3} //type array

string interpolation字符串插值 目前不支持, 使用fmt.Sprintf()


make 的作用是初始化内置的数据结构，也就是我们在前面提到的切片、哈希表和 Channel
    make(chan int)
new 的作用是根据传入的类型分配一片内存空间并返回指向这片内存空间的指针
    obj := new(StudentInfo)


go mod download时， 使用ssh协议，不使用https
    git config --global --add url."git@your-repo.com:".insteadOf "https://your-repo.com/"
    export GOPRIVATE='your-repo.com'

go mod download -x 打印下载详情


go help [<command>|<topic>]
go help mod <command>


return value from goroutine
    func doSomething() string{
        return "test"
    }
    go func(){
        x = doSomething()
    }()


os/exec 不会自动调用shell
    Unlike the "system" library call from C and other languages, the os/exec package intentionally does not invoke the system shell and does not expand any glob patterns or handle other expansions, pipelines, or redirections typically done by shells. The package behaves more like C's "exec" family of functions. To expand glob patterns, either call the shell directly, taking care to escape any dangerous input, or use the path/filepath package's Glob function. To expand environment variables, use package os's ExpandEnv.

	cmd := exec.Command("bash", "-c", "sleep 1; echo good")


查看某个repo都依赖了什么package
    go mod graph|grep github.com/user/repo  

go.mod
    replace
        old_name => new_name <version>


go不支持函数重载, 设计者认为该特性偶尔会被使用，并且非常脆弱

go生成的可执行文件自动包含了垃圾回收代码，会自动用一个线程进行垃圾回收

go package name可以跟directory name不一样, 按照文件夹路径进行import, 按照package name进行使用
相同文件夹下的所有go文件，package name必须是一样的


字符串拼接支持 str1 + str2

编译期接口检查code/interface_check.go

函数名首字母小写的，可以在同package内使用，被外部import时不可用

无法对函数取地址  &someFunc

声明interface

	type geometry interface {
		area() float64    //无需func关键字和{}
		perim() float64
	}

参数类型为func code/func_arg_type.go
```

