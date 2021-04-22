package main
import (
    "fmt"
)

type Base struct{
    info string //因为Container有同名field，所以此为Shadowed Field
    tag string
}

type Container struct{
    Base
    info string
}


func (b Base) DescribeTag(){
    fmt.Println(b.tag)
}

func main(){
    //第一种初始化
    c := new(Container)
    c.tag = "c's tag" //promoted field 
    c.info = "c's info"

    c.DescribeTag() //promoted method

    //第二种初始化, 需要先初始化一个Base实例
    b := Base{info: "b's info", tag: "b's tag"}
    d := Container{Base: b, info: "c's info"}
    d.DescribeTag()

    //fmt.Printf("%v\n",c)
}
