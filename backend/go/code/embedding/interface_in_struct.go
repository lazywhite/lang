package main

import (
    "fmt"
)
type MyFoo interface{
    Foo() string
}


type Container struct{
    MyFoo //意味着可以调用Container.MyFoo.Foo(), 因此构造出的Container必须具备这个条件
}

type Real struct{
    Info string
}

func (r Real) Foo() string{
    return "Real foo"
}

func sink(f MyFoo){
    fmt.Printf("%s\n", f.Foo())
}



func main(){
    r := Real{}
    c := Container{MyFoo: r} //MyFoo作为Field Name进行赋值
    fmt.Println(c.Foo())
    sink(c)
}
