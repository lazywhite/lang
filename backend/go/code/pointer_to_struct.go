package main

import "fmt"
import "reflect"

type Point struct {
	X int
	Y int
}
type Config struct {
	Username string
	Vex      *Point
}

func main() {
	p := &Point{100, 200}
	n := Point{100, 200}

	q := &p

	c := &Config{"Bob", p}
	d := Config{"Bob", p}

	//	fmt.Printf("%v", c.Vex)
	fmt.Printf("type of c.Vex: %s\n", reflect.TypeOf(c.Vex))
	fmt.Printf("type of p: %s\n", reflect.TypeOf(p))
	fmt.Printf("type of p.X: %s\n", reflect.TypeOf(p.X))

	fmt.Printf("type of q: %s\n", reflect.TypeOf(q))
	fmt.Printf("value of p: %s\n", reflect.TypeOf(*q))
	fmt.Printf("value of value of p: %s\n", reflect.TypeOf(**q))

	fmt.Printf("type of n: %s\n", reflect.TypeOf(n))
	fmt.Printf("type of c: %s\n", reflect.TypeOf(c))
	fmt.Printf("type of d: %s\n", reflect.TypeOf(d))

}
