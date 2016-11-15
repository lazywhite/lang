package main
import "fmt"

/*
	1. channel can be used as a synchronize tool between Goroutines
	2. channel can be bufferd 
		ch := make(chan int, 100)  //length is 100
	3. sends is blocked when buffer is full
	    recv is blocked when buffer is empty
*/

func fibonacci(n int, c chan int) {
	x, y := 0, 1
	for i := 0; i < n; i++ {
		c <- x
		x, y = y, x+y
	}
	close(c) //
}

func sum(s []int, c chan int){
	sum := 0
	for _, v  := range s{
		sum += v
	}
	c <- sum
}

func main(){
	s := []int{1, 2, 3, 4, 5, 6}
	ch := make(chan int)
	go sum(s[:len(s)/2], ch)
	go sum(s[len(s)/2:], ch)
	s1, s2 := <-ch, <-ch
	fmt.Println(s1 + s2)


	c := make(chan int, 10)
	go fibonacci(cap(c), c)
// 1. use "range" to loop over channel
//	for i := range c{
//		fmt.Println(i)
//	}
// 2. use "for" to loop over channel
	for data, ok := <-c; ok ;{
		fmt.Println(data)
		data, ok = <-c
	}
}

