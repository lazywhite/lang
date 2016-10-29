package main

import "net/http"
import "fmt"

func main() {
	resp, err := http.Head("http://www.baidu.com")
	fmt.Println(resp.StatusCode)
	fmt.Println(err)
}
