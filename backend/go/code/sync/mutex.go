package main

import "fmt"

import (
	"sync"
	"time"
)

func main() {
	wg := sync.WaitGroup{}
	var lock sync.Mutex

	fmt.Println("locked in main")
	lock.Lock()
	for i:=1;i<4;i++{

		wg.Add(1) // add delta
		go func(i int){

			fmt.Printf("%d not locked\n", i)
			lock.Lock()
			fmt.Printf("%d accqured lock\n", i)
			time.Sleep(time.Second)
			fmt.Printf("%d work done\n", i)
			lock.Unlock()
			fmt.Printf("%d release lock\n", i)

			defer wg.Done()

		}(i)
	}

	time.Sleep(time.Second)
	lock.Unlock()
	fmt.Println("unlocked in main")
	wg.Wait()
	fmt.Println("main done")
}
