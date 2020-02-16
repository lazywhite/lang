//
// b.go
// Copyright (C) 2020 white <white@Whites-Mac-Air.local>
//
// Distributed under terms of the MIT license.
//

package main

import (
    "fmt"
    "reflect"
)
func main(){
    // <- 总是尝试与左边的chan结合, 因此channel类型最好用小括号区分出来
    b := make(chan <-chan int)
    c := make(chan (<-chan int))
    d := make(chan <-chan int)
    e := make(<-chan <-chan int)
    f := make(<-chan (<-chan int))
    t1 := reflect.TypeOf(b)
    t2 := reflect.TypeOf(c)
    t3 := reflect.TypeOf(d)
    t4 := reflect.TypeOf(e)
    t5 := reflect.TypeOf(f)
    fmt.Println(t1 == t2)
    fmt.Println(t1 == t3)
    fmt.Println(t4 == t5)
    // fmt.Println(t1)
    // fmt.Println(t2)
    // fmt.Println(t3)
}
