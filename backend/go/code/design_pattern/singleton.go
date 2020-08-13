package main

import (
	"fmt"
	"sync"
)

type Singleton map[string]string

var once sync.Once

var st Singleton



func main() {
	fmt.Println("vim-go")

	s1 := New()
	s1["this"] = "thing"
	s2 := New()
	fmt.Printf("%s\n", s2["this"])
}


func New() Singleton{
	once.Do(func(){
		st = make(Singleton)
	})

	return st
}
