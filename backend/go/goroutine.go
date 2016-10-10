package main

import "fmt"
import "time"

func f(from string) {
	for i := 0; i < 10; i++ {
		fmt.Println(from, ":", i)
		time.Sleep(3 * time.Second)
	}
}

func main() {
	//f("direct") //block until loop over
	// goroutings will get executed concurrently
	go f("goroutine")
	go f("another goroutine")

	var input string
	fmt.Scanln(&input)

	fmt.Println("done")

}
