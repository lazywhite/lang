package main

import (
    "fmt"
    "io/ioutil"
    "net/http"
)




func main(){
    resp, err := http.Get("https://www.baidu.com?key=v")
    if err != nil {
    	panic(err)
    }

    defer resp.Body.Close()
    body, _ := ioutil.ReadAll(resp.Body)

    fmt.Println(body)
    fmt.Println(resp.Status)
    fmt.Println(resp.StatusCode)
    fmt.Println(resp.Header)


}
