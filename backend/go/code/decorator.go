//
// decorator.go
// Copyright (C) 2017 white <white@Whites-Mac-Air.local>
//
// Distributed under terms of the MIT license.
//

package main

import (
	"fmt"
	"reflect"
	"runtime"
	"time"
)

//func decorator(f func(s string)) func(s string){
//    return func(s string){
//        fmt.Println("started")
//        f(s)
//        fmt.Println("stopped")
//    }
//}
//func Hello(s string){
//    fmt.Println(s)
//}

type SumFunc func(int64, int64) int64

func getFuncName(i interface{}) string {
	return runtime.FuncForPC(reflect.ValueOf(i).Pointer()).Name()
}

func timedSumFunc(f SumFunc) SumFunc {
	return func(start, end int64) int64 {

		defer func(t time.Time) {
			fmt.Printf("--- Time Elapsed (%s): %v ---\n",
				getFuncName(f), time.Since(t))
		}(time.Now())

		return f(start, end)
	}
}

func Sum1(start, end int64) int64 {
	var sum int64
	sum = 0
	if start > end {
		start, end = end, start
	}
	for i := start; i <= end; i++ {
		sum += i
	}
	return sum
}

func Sum2(start, end int64) int64 {
	if start > end {
		start, end = end, start
	}
	return (end - start + 1) * (end + start) / 2
}

func main() {
	//	hello := decorator(Hello)
	//	hello("hello")

	sum1 := timedSumFunc(Sum1)
	sum2 := timedSumFunc(Sum2)

	fmt.Printf("%d, %d\n", sum1(-10000, 100000), sum2(-10000, 100000))
}
