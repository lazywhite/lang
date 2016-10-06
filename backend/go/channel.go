/*
Channels are the pipes that connect concurrent goroutines. You can send values into channels from one goroutine and receive those values into another goroutine.
*/
package main

import "fmt"

func main() {
	message := make(chan string)
	go func() { message <- "ping" }()
	msg := <-message
	fmt.Println(msg)
}
