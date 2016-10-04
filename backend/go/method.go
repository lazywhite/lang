package main

import (
	"fmt"
	"math"
)

type Vertex struct {
	X, Y float64
}

func (v Vertex) Abs() float64 {
	return math.Sqrt(v.X*v.X + v.Y*v.Y)
}

func main() {
	n := Vertex{3, 4}
	m := Vertex{5, 12}

	fmt.Println(n.Abs())
	fmt.Println(m.Abs())
}
