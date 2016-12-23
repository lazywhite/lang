package main

import (
	"sync"
	"sync/atomic"
	"time"
	"math/rand"
	"fmt"
	"runtime"
)
/*
互斥锁
*/

func main(){
	var state = make(map[int]int)
	var total = make(map[int]int)
	var mutex = &sync.Mutex{}
	var ops uint64 = 0

	for r:=0;r<100;r++{
		go func(){
			for {
				key := rand.Intn(5)
				mutex.Lock()
				total[key] += state[key] //atomic read/write 
				mutex.Unlock()
				atomic.AddUint64(&ops, 1)

				runtime.Gosched()
			}
		}()
	}

	for w:= 0; w< 10; w++{
		go func(){
			for {
				key := rand.Intn(5)
				val := rand.Intn(100)
				mutex.Lock()
				state[key] = val //atomic write 
				mutex.Unlock()
				atomic.AddUint64(&ops, 1)
				runtime.Gosched()
			}
		}()
	}

	time.Sleep(time.Second)
	opsFinal := atomic.LoadUint64(&ops)
	fmt.Println("ops: ", opsFinal)
	mutex.Lock()
	fmt.Println("total: ", total)
	fmt.Println("state: ", state)
	mutex.Unlock()

}
