package main

import ("time"
		"fmt"
	)

	/*
	select let you wait on multiple channel operations, combining "goroutines"
	and "channels" with "select" is a powerful feature of GO

	without "default", execution of "select" is blocked
	*/

func main(){
	c1 := make(chan string)
	c2 := make(chan string)

	defer fmt.Println("main exit")

	go func(){
        for{
            time.Sleep(time.Second * 1)
            c1 <- "one"
        }
	}()
	go func(){
        for{
            time.Sleep(time.Second * 2)
            c1 <- "two"
        }
	}()


	for {
		select {
			case msg1 := <-c1:
				fmt.Println("received", msg1)
			case msg2 := <-c2:
				fmt.Println("received", msg2)
            // default:
			// 	fmt.Println("noting received")
            //     time.Sleep(time.Millisecond * 500)
		}
		fmt.Println("one loop ended")
	}
}

