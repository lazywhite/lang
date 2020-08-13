package main

import (
	"fmt"
	"sync"
)

var once sync.Once

func main() {

	for i:=1;i<10;i++{
		Run()
	}
}


func te(){
	fmt.Println("vim-go")
}


func Run(){
	once.Do(te)

}
