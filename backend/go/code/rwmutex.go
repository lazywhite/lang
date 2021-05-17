package main

import (
    "fmt"
    "sync"
    "time"
)

func main() {

    lock := sync.RWMutex{}
    /*
    a := 0

    for i := 1; i < 10; i++ {
        go func(i int) {
            lock.Lock()
            fmt.Printf("Lock: from go routine %d: a = %d\n",i, a)
            time.Sleep(time.Second)
            lock.Unlock()
        }(i)
    }

     */

    b := 0

    /*
    lock := sync.RWMutex{} //初始化一个读写锁
    RLock()启用读锁，所有goroutine都可以拿到, 最后需要执行RUnlock()
    一旦有goroutine调用了Lock()写锁，则所有的RLock()将被阻塞, 直到被调用了Unlock()

    结论: 有写操作则执行Lock()写锁， 没有则调用RLock()
     */
    for i := 11; i < 20; i++ {
        go func(i int) {
            time.Sleep(time.Second)
            if i < 15 {
                lock.RLock()
                fmt.Printf("RLock: from go routine %d: b = %d\n", i, b)
                lock.RUnlock()
            }
            if i == 15{
                lock.Lock()
                fmt.Printf("Lock: from go routine %d: b = %d\n",i, b)
                b = 20
                lock.Unlock()
            }
            if i > 15{
                lock.RLock()
                fmt.Printf("RLock: from go routine %d: b = %d\n",i, b)
                lock.RUnlock()
            }
        }(i)
    }

    <-time.After(time.Second*10)
}
