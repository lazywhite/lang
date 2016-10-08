package main

/*
   Nanosecond  Duration = 1
   Microsecond          = 1000 * Nanosecond
   Millisecond          = 1000 * Microsecond
   Second               = 1000 * Millisecond
   Minute               = 60 * Second
   Hour                 = 60 * Minute
*/

import "fmt"
import "time"

func main() {
	fmt.Println("vim-go")
	time.Sleep(1 * time.Second)
	fmt.Println("vim-go")
	time.Sleep(1000 * time.MilliSecond)
	fmt.Println("vim-go")
}
