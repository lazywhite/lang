package main

import "fmt"
import "time"
import "math/rand"
import "math"
import "runtime"
import "errors"

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

Type Casting: 
	T(v) convert value "v" to type  "T"
*/

var c, python, java bool //package level variable
const (
	GREET string = "hello world"
	Prob string = "NOE"
)

type Vertex struct{
	X, Y float64
}
func (v Vertex) Abs() float64 {
	return math.Sqrt(v.X * v.X + v.Y * v.Y)
}

/** variables decclared without an explicit have initial value

1. 0 for numeric types
2. false for boolean type
3. "" for string
**/

// format output https://golang.org/pkg/fmt/
func add(x int, y int) int {
	return x + y
}

func swap(x, y string) (string, string) {
	return y, x
}

// generate a random number in a range
func random(min, max int) int {
    rand.Seed(time.Now().Unix())
    return rand.Intn(max - min) + min
}

// named return value
func split(sum int) (x, y int) {
	x = sum * 4 / 9
	y = sum - x
	return // "naked" return, not recommanded
}

func for_demo() {
	fmt.Println("For loop demo started")
	for i := 0; i < 5; i++ {
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
		fmt.Println(i)
	}
	fmt.Println("For loop demo ended")
}

func if_demo(x float64) bool {
	if v := math.Pow(x, 2); v < 100 {
		// if statement can start with a short statement to execute before the condition
		return true
	}
	return false
}

func switch_demo() {
	fmt.Println("Swith statement: Detecting OS")
	switch os := runtime.GOOS; os {
	/**
	1. switch statement can start with a short statement
	2. cases evaluated from top to bottom, stopping when a case successed
	**/

	case "darwin":
		fmt.Println("OS X")
		fallthrough
	case "windows":
		fmt.Println("Fallthrough")
		fmt.Println("Windows")
	case "linux":
		fmt.Println("Linux")
	default:
		fmt.Println("%s", os)
	}
}

func switch_true() {
	t := time.Now()
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

	defer sayBye()

	fmt.Printf("random number between (10, 20) is : %d\n" , random(10, 20))
	fmt.Printf("Const: %s\n" , GREET)
	fmt.Println("Weekday of current time: ", time.Now().Weekday())
	fmt.Printf("Square of 7 is %.2f\n", math.Sqrt(7))
	fmt.Printf("Sumation of 2 and 4 %d\n", add(4, 2))
	a, b := "hello", "world"
	fmt.Println("Short assignment: ", a, b)
	c, d := swap(a, b)
	fmt.Println("Variable switched: ", c, d)
	m1, n1 := split(17)
	fmt.Println("Named return value, splited of 17: ", m1, n1)
	fmt.Printf("Global variable python is: %t\n", python)
	for_demo()
	fmt.Println(if_demo(9))
	switch_demo()
	switch_true()



	/* Struct
	1. a struct is a collection of fields
	2. struct field is accessed by a dot
	3. struct field can be accessed by struct pointer
	*/

	/* 
		go does not has class, however you can define methods on types
		Method is a special function with a special "receiver" argument
	*/
	point := Vertex{30, 40}
	fmt.Println("Type method example: ", point.Abs())


	/* Array
	1. array has fixed size, could not be resized
	2. zero value of array items is 0
	3. a slice is dynamically-sized
	4. a slice does not store any data, it just desribe a section of underlying array
	changing the element of slice, other slices share the same underlying array will see the change

	5. A slice literal is like an array literal without the length.
	6. slice has length and capacity
	7. nil slice has 0 length, 0 capacity and has no underlying array
	8. use make() to create dynamically-sized arrays
	9. slice high or low bound may be ommited, it will use its default
	10. the zero value of a slice is "nil"
	*/

	strArray := [2]string{"hello", "world"} // this declare an Array
	fmt.Printf("%v\n", strArray)

	var pow = []int{1, 2, 4, 8, 16, 32} // this create an Array then builds a slice reference it

	for i, v := range pow {
		// range is used for iterate over slice or map
		// you can skip index or value by assign it to "_"
		// if you only want the index, drop the ",value" entirely
		fmt.Printf("2 ** %d = %d\n", i, v)
	}
	var s []int = pow[0:4] //4 is not included
	printSlice("s", s)

	aSlice  := make([]int, 5)
	printSlice("aSlice", aSlice)

	aSlice = append(aSlice, 100)
	printSlice("aSlice", aSlice)

	/* Map
	*map maps keys to values
	1. zero value of a map is nil
	2. a nil map has no keys, nor can keys be added
	3. make() return a map of given type, initialized and ready to use
	*/



	m := make(map[string]Vertex) // declare m as an map
	m["Bell Lab"] = Vertex{
		30, -40,
	}
	fmt.Println(m["Bell Lab"])

	n := map[string]Vertex{ //declare and initialize a map
		"Bell": Vertex{
			10, 20, 
		},
		"Google": Vertex{
			30, 40,
		},
	}
	fmt.Println(n)
	// delete(<m map>, key string) delete an item from map
	// elem, ok := m[key]   test if map kas key 

	fmt.Println("Using range to loop over a Map")
	for k, v := range n{ //iterator an map
		fmt.Println(k, v)
	}


	// Recursion
	fmt.Println("Recursion test, fib(10): ", fib(10))

	// Error handling
	result, err := Sqrt(100)
	if err != nil {
		fmt.Println(err) 
	}else{
		fmt.Println(result)
	}

}

func printSlice(name string, s []int) {
	fmt.Printf("slice name: %s len=%d cap=%d %v\n", name, len(s), cap(s), s)
}

// func as parameter
func sayBye(){
	fmt.Println("Good bye")
}


func fib(n int) int {
	if n == 1{
		return 1
	}
	if n == 0 {
		return 1
	}
	return fib(n-1) + fib(n-2)
}

func Sqrt(value float64) (float64, error){
	if value < 0{
		return 0, errors.New("Math: negative number is not supported")
	}else{
		return math.Sqrt(value), nil
	}
}
