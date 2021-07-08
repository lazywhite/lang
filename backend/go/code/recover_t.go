package main

import (
    "fmt"
    "time"
)

/*
recover()只能在当前goroutine捕获panic，无法跨goroutine
 */

func Foo() {
    panic("Panic in Foo() !")
}

func Game() {
    defer func(){
        fmt.Println("Clean up in Game()")
    }()

    defer func() {
        if x := recover(); x != nil {
            fmt.Println("Catch recover panic !!! In Game()")
            fmt.Println(x)
        }
    }()
    go Foo()

}

func main() {

    defer func() {
        fmt.Println("Program Quit ... ")
    }()

    go Game()
    time.Sleep(1 * time.Millisecond)
    fmt.Println("-----------Split-------------")
}
