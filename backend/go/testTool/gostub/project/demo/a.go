package demo

import (
    "fmt"
    "encoding/json"
)

var Name = "bob"
//外部库函数， 无法重构成匿名函数, 可以用下面方法
var Marshal = json.Marshal
var Unmarshal = json.Unmarshal

func GreetInfo(name string) string{
    return "hello " + Name + "!"
}


type Student struct{
    Name string
    Age int
}

func (s *Student) ToString() string {
    data, err := Marshal(s)
    if err != nil{
        panic("json marshal error")
    }
    return string(data)


}

var greeting = func(){
    fmt.Println("hello")
}
