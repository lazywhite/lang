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
optional binding
    将
    var some2: Int = 100
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
        构造函数
        使用extention
        遵守protocol
    class独有
        允许集成
        type casting
        析构函数
        引用计数
        

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
