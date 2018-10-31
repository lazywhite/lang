package main

import (
    "fmt"
    "bytes"
    "net/http"
)




func main(){
    resp, err := http.Get("www.baidu.com")
    if err != nil {
        fmt.Println("test")
        return
    }

    defer resp.Body.Close()
    buf := bytes.NewBuffer(make([]byte, 0, 512))
    length, _ := buf.ReadFrom(resp.Body)
    fmt.Println(length)
    fmt.Println(string(buf.Bytes()))


}
