package main
import (
    "fmt"
)

func modify(num int, f func(int) int){
    fmt.Println(f(num))
}

func addOne(i int)int{
    return i + 1
}
var addTwo = func(i int) int{
    return i + 2
}

func main(){
    a := 10
    modify(a, addOne)
    modify(a, addTwo)
}
