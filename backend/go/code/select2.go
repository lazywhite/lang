package main

import (
	"fmt"
	"time"
)

func task(c chan string, sec int64) error {
	fmt.Println("start")
	time.Sleep(time.Second * time.Duration(sec))

	c <- "done"
	return nil
}

func main(){

	c1 := make(chan string)
	c2 := make(chan string)

	defer fmt.Println("main exit")
	defer close(c1)
	defer close(c2)
	go task(c1, 1)
	go task(c2, 2)


	for i:=0;i<2;i++{
		select {
		case msg1 := <- c1:
			fmt.Println("taks1 return", msg1)
		case msg2 := <- c2:
			fmt.Println("taks2 return", msg2)
		}
	}
}
