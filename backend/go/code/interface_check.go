package main

import (
    "io"
    "fmt"
)


type myWriter struct {

}

func (w myWriter) Write(p []byte) (n int, err error) {
	return
}


func init(){
    // 检查 *myWriter 类型是否实现了 io.Writer 接口
    var _ io.Writer = (*myWriter)(nil)

    // 检查 myWriter 类型是否实现了 io.Writer 接口
    var _ io.Writer = myWriter{}
    fmt.Println("run init")
}

func main() {
    fmt.Println("run main")
}
