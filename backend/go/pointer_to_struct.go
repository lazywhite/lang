package main

import "fmt"

type Vex struct {
	X, Y float32
}

func main() {
	v := Vex{100.55, 200.34}
	p := &v

	p.X = 300.78 //use "p" instead of "*p"
	fmt.Printf("Vex v: %v\n", v)

}
