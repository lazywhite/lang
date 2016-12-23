package main

import "fmt"
/*
make(chan string, [size]) without size, channel is unbufferd
*/

func main(){
	messages := make(chan string)//unbuffered channel
	go func(){messages <- "hello"}()
	fmt.Println(<-messages)
}
