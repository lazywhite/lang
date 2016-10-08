package main

import "fmt"
import "time"
import "math/rand"
import "math"
import "runtime"

//import "github.com/lib/pq"

/* Basic types
bool
string
int int8 int16 int32 int64
unit unit8 unit16 unit32 unit64 unitptr
byte
rune
float32 float64
complex64 complex128


T(v) convert value "v" to type  "T"
*/

var c, python, java bool //package level variable

/** variables decclared without an explicit have initial value

1. 0 for numeric types
2. false for boolean type
3. "" for string
**/

func add(x int, y int) int {
	return x + y
}

func swap(x, y string) (string, string) {
	return y, x
}

// named return value
func split(sum int) (x, y int) {
	x = sum * 4 / 9
	y = sum - x
	return // "naked" return, not recommanded
}

func for_demo() int {
	sum := 0
	for i := 0; i < 10; i++ {
		/** For loop
		three components seperated by semicolons
		init statement
		condition expression
		post statement

		1. no parenthese surrounding the three components of the for statement
		2. init and post statements are optional
		3. semicolons are optional too, "for" will looks like "while"
		4. for {} : loop forever

		**/
		sum += i
	}
	return sum
}

func if_demo(x float64) bool {
	if v := math.Pow(x, 2); v < 100 {
		// if statement can start with a short statement to execute before the condition
		return true
	}
	return false
}

func switch_demo() {
	fmt.Println("Detecting OS")
	switch os := runtime.GOOS; os {
	/**
	1. switch statement can start with a short statement
	2. cases evaluated from top to bottom, stopping when a case successed
	**/

	case "darwin":
		fmt.Println("OS X")
		fallthrough
	case "windows":
		fmt.Println("Windowns")
	case "linux":
		fmt.Println("Linux")
	default:
		fmt.Println("%s", os)
	}
}

func switch_true() {
	t := time.Now()
	fmt.Println(t)
	//Switch without a condition is the same as switch true.
	//This construct can be a clean way to write long if-then-else chains.
	switch {
	case t.Hour() < 12:
		fmt.Println("good morning")
	case t.Hour() < 17:
		fmt.Println("good afternoon")
	default:
		fmt.Println("good evening")
	}
}

func main() {
	var i int = 10 //function level variable
	//	p := &i        // pointer to variable "i"

	/** Pointer
	1. pointer zero value is nil
	2. go has no pointer arithmetic

	var q *int32 //declare a pointer to an int value
	*q = 100     //set value
	**/

	/**var j, k int = 10, 20

	m, n := 10, 20
	":=" short assignment statement
	1. outside a function, every statement begines with a keyword (var, func ...) ":=" is not available
	2. const can not be declared using := syntax
	**/

	/**
	1. defer statement defers the execution of a function until the surrounding function returns

	2. the defered call's arguments are evaluated immediatly, but the function call is not executed until the surrounding function returns


	3. defered function calls are pushed onto a statck, defered calls are executed in last-in-first-out order
	**/
	defer fmt.Println("world")

	//	for i := 0; i < 10; i++ {
	//		defer fmt.Println(i)
	//	}

	fmt.Println("Hello")
	fmt.Println("time is", time.Now().Weekday())
	rand.Seed(time.Now().UnixNano())
	fmt.Printf("random number\n", rand.Intn(10))
	fmt.Printf("Square of 4 is %.2f\n", math.Sqrt(4))
	fmt.Printf("add of 2 and 4 %d\n", add(4, 2))
	a, b := swap("Hello", "World")
	fmt.Println(a, b)
	fmt.Println(split(17))
	fmt.Println(i, c, python, java)
	fmt.Println(for_demo())
	fmt.Println(if_demo(9))
	//	fmt.Printf("value of pointer P is: %d\n", *p)
	//fmt.Printf("address of  pointer q is: %s\n", q)
	//	runtime.Breakpoint()
	switch_demo()
	switch_true()

	/* Struct
	1. a struct is a collection of fields
	2. struct field is accessed by a dot


	3. struct field can be accessed by struct pointer
	*/
	type Vertex struct {
		X, Y float64
	}

	//	func (v Vertex) Abs() float64 {
	//		return math.Sqrt(v.X * v.X + v.Y * v.Y)
	//	}
	//	point := Vertex{100, 20}

	//	fmt.Println(Vertex{1, 2})
	//	fmt.Println(point.X)

	/* go does not has class, however you can define methods on types
	a method is a special function with a special receiver argument
	*/

	/* Array
	1. array has fixed size, ould not be resized
	2. zero value of array items is 0
	3. a slice is dynamically-sized
	4. a slice does not store any data, it just desribe a section of underlying array
	changing the element of slice, other slices share the same underlying array will see the change

	5. A slice literal is like an array literal without the length.
	6. slice has length and capacity
	7. nil slice has 0 length, 0 capacity and has no underlying array
	8. use make() to create dynamically-sized arrays
	*/

	var array_test [10]int
	fmt.Println(array_test[5])

	primes := [6]int{2, 3, 5, 7, 11, 13}
	var s []int = primes[1:4] // index 4 is not included
	fmt.Println(s)
	printSlice(s)

	var sn []int
	printSlice(sn)
	sn = append(sn, 0)
	printSlice(sn)
	sn = append(sn, 2, 3, 4)
	printSlice(sn)

	var pow = []int{1, 2, 4, 8, 16, 32}

	for i, v := range pow {
		// range is used for iterate over slice or map
		// you can skip index or value by assign it to "_"
		// if you only want the index, drop the ",value" entirely
		fmt.Printf("2 ** %d = %d\n", i, v)
	}

	/* Map
	*map maps keys to values
	1. zero value of a map is nil
	2. a nil map has no keys, nor can keys be added
	3. make() return a map of given type, initialized and ready to use
	*/

	type Cstruct struct {
		Lat, Long float64
	}
	var m map[string]Cstruct
	m = make(map[string]Cstruct)
	m["Bell Labs"] = Cstruct{
		40.68433, -74.39967,
	}
	m["Bily Mando"] = Cstruct{
		20.89, -777.60,
	}
	fmt.Println(m["Bell Labs"])

	for k, v := range m {
		fmt.Printf("key: %s, value: %v\n", k, v)
	}

	//	var n map[string]string
	//	n = make(map[string]string)
	//	n["key1"] = "value1"
	//	fmt.Println(n["key1"])
	var n = map[string]int32{
		"key1": 400,
		"key2": 200,
	}
	fmt.Println(n["key1"])

	//	printMap(n)

	//	type Mtype1 map[string]int
	hypot := func(x, y float64) float64 {
		return math.Sqrt(x*x + y*y)
	}
	fmt.Println(hypot(5, 12))
	//	fmt.Println(compute(hypot))

}

func printSlice(s []int) {
	fmt.Printf("len=%d cap=%d %v\n", len(s), cap(s), s)
}

//func printMap(tMap Mtype1) {
//	for k, v := range tMap {
//		fmt.Printf("key=%s value=%d\n", k, v)
//	}
//}

//func compute(fn func(float64, float64) float64) float64 {
// functions are value too, they could be passed around like values
//	 may be used as function arguments and return value
//	return fn(3, 4)
//}

// channel
// buffer
// select
// reader writer
// range and close
// goroutine
// interface
// Stringer
