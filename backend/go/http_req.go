package main

import "net/http"
import "fmt"

func main() {
	resp, err := http.Get("http://www.baidu.com")
	fmt.Println(err)
	fmt.Println(resp)
}
