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
	fmt.Printf("%s\n", reflect.TypeOf(c.Vex))
	fmt.Printf("%s\n", reflect.TypeOf(p))
	fmt.Printf("%d\n", p.X))

	fmt.Printf("%s\n", reflect.TypeOf(q))

	fmt.Printf("%v\n", **q)
	fmt.Printf("%s\n", reflect.TypeOf(n))
	fmt.Printf("%s\n", reflect.TypeOf(c))
	fmt.Printf("%s\n", reflect.TypeOf(d))

}
