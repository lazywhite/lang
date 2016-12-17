package main
import (
	"fmt"
	"math"
)

/*
function definition using short assignment
function as parameter
function as return value
*/

func compute(fn func(float64, float64) float64 ) float64 {
	return fn(3, 4)
}

func hypot(x float64, y float64) float64{
	return math.Sqrt(x*x +y*y)
}


func multi(x int) int{
	return x*x
}


func deco(fn func(int) int, arg int, greet string) {
	fmt.Printf("%s result is: %d\n", greet, fn(arg))
}

func deco02(fn (func(int) int)) (func(int) int){
	wrapped := func(x int) int {
		fmt.Println("before function")
		return fn(x)
	}
	return wrapped
}
func main(){
	hypot02 := func(x float64, y float64) float64{ //lambda assignment
		return math.Sqrt(x*x +y*y)
	}
	fmt.Println(compute(hypot))
	fmt.Println(compute(hypot02))
	deco(multi, 10, "hello")
	fmt.Println(deco02(multi)(10))
}
