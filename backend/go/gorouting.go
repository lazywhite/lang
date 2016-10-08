package main

import "fmt"

func f(from string) {
	for i := 0; i < 30; i++ {
		fmt.Println(from, ":", i)
	}
}

func main() {
	f("direct") //block until loop over
	// goroutings will get executed concurrently
	go f("goroutine")
	go f("another goroutine")

	var input string
	fmt.Scanln(&input)

	fmt.Println("done")

}
