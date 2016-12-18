package main

import (
	"fmt"
//	"net"
	"net/url"
)
func main(){
	s := "http://test.example.com/demo?k1=v1&k2=v2"

	u, err := url.Parse(s)
	if err != nil{
		panic(err)
	}
	fmt.Println(u.Scheme)
	fmt.Println(u.Path)
	fmt.Println(u.RawQuery)
	fmt.Println(u.Host)
}
