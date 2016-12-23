package main

import (
	"fmt"
	"os"
	"os/signal"
	"syscall"
)

func main(){
	sigs := make(chan os.Signal, 1)
	done := make(chan bool, 1)

	signal.Notify(sigs, syscall.SIGINT, syscall.SIGTERM)//register the given
	//channel to receive notifications of the specified signals

	go func(){
		sig := <-sigs //blocked until it get one 
		fmt.Println()
		fmt.Println(sig)
		done <-true
	}()

	fmt.Println("awaiting signal")
	<-done //blocked until chan received data
	fmt.Println("exiting")

}
