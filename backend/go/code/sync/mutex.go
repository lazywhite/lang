package main

import (
	"fmt"
	"sync"
)

func task(l *sync.Mutex, wg *sync.WaitGroup, i int){
	defer wg.Done()
	l.Lock()
	fmt.Printf("after get lock by %d\n", i)
	fmt.Printf("before release lock by %d\n", i)
	l.Unlock()
}

func main(){
	lock := new(sync.Mutex)
	wg := new(sync.WaitGroup)
	for i:=0;i<10;i++{
		wg.Add(1)
		go task(lock, wg, i)
	}
	defer fmt.Println("main end")
	wg.Wait()

}
