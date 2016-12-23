package main

import "runtime"
import "fmt"
import "time"


func main(){
	runtime.GC()
	n := runtime.NumCPU()
	fmt.Println(n)
	fmt.Println(runtime.GOMAXPROCS(n))
	fmt.Println(runtime.Version())

	go func(){
		for i:=0;i<=100;i++{
			fmt.Printf("current i is %d\n", i)
			if i == 5{
				runtime.Goexit() //exit current goroutine
			}
			time.Sleep(time.Second)
		}
	}()

	go func(){
		for i:=50;i<=100;i++{
			fmt.Printf("current i is %d\n", i)
			if i == 53{
				runtime.Gosched() //suspend the execution of goroutine
				time.Sleep(10 * time.Second)
			}
			time.Sleep(time.Second)
		}
	}()

	var input string
	fmt.Scanln(&input)

}

