package main
/* Struct
1. a struct is a collection of fields
2. struct field is accessed by a dot
3. struct field can be accessed by struct pointer


go does not has class, however you can define methods on types
a method is a special function with a special receiver argument


method and struct definition must in the same package
built-in types like "int" considered as defined in other package
so cannot define method for them directly, but by using "type alias"
*/

import (
	"fmt"
	"math"
)

type myInt int  // type alias
func (i myInt) Abs() int {
	if i < 0 {
		return int(-i)
	}
	return int(i)
} //define method for local non-struct type


type Vertex struct {
	X, Y float64
}

func (v Vertex) Abs() float64 {
	return math.Sqrt(v.X*v.X + v.Y*v.Y)
}

func main() {
	var p myInt = 10

	n := Vertex{3, 4}
	m := Vertex{5, 12}

	fmt.Println(n.Abs())
	fmt.Println(m.Abs())
	fmt.Println(p.Abs())
}

