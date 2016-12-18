package main

import "time"
import "fmt"

/*
used for executing go code once at some point in the future
*/
func main(){
	timer1 := time.NewTimer(time.Second * 2)
	<-timer1.C // this phrase blocks on the timer's channel C until it sends
			// a value indicating that the timer expired
	fmt.Println("Timer1 expired")

	timer2 := time.NewTimer(time.Second)

	go func(){
		<-timer2.C
		fmt.Println("Timer2 expired")
	}()

	stop2 := timer2.Stop()
	if stop2 {
		fmt.Println("Timer2 stopped")
	}
}
