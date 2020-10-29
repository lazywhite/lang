package main

import (
	"fmt"
	"github.com/lazywhite/util"
	. "./helper"
	"time"
	//		"math/rand"
)


const PI float32 = 3.14
const GREET  = "hello"
func main(){
	var age int = 10
	//	fmt.Println(PI * age)
	var name string = "bob"
	var test bool = true
	var fl float64 = 1.23
	//	var b byte = 8
	fmt.Println("printed by main")
	fmt.Printf("test is %t\n",  test)
	fmt.Printf("fl is %f\n",  fl)
	fmt.Printf("type of fl is %T\n",  fl)
	//	PI = 100 //cannot assign to a const
	//	fmt.Printf("b is %b\n",  b)
	fmt.Printf("PI is %.3f\n",  PI)
	util.Greet(name)
	c := Child{Name: name, Age: age}
	//	c := Child{name, age}  // field name could be omitted
	fmt.Printf("Child c name: %s age: %d", c.Name, c.Age)
	if (1 < 3 && 32> 16){ //brace should be used here when testing multiple conditions
		fmt.Println("if test")
	}
	m, n := Switch(100, 200)
	fmt.Printf("m: %d, n: %d\n", m, n)

	//	var mkArray = make([]string, 10) //initialize an array using make()

	var balance = [5]int{1,2,3} // zero value of array is 0
	fmt.Printf("balance %v\n", balance)
	fmt.Printf("cap of balance is %d\n", cap(balance))

	//	balance = append(balance, 10)  //array size is fixed
	var sli = []int{1,2,3,4}
	sli = append(sli, 100) //slice size is not fixed
	sli = append(sli, 3, 3)
	fmt.Printf("sli %#v\n", sli)
	fmt.Printf("sli %v\n", sli)

	for _, value := range sli {
		fmt.Println(value)
	}

	result := []int{}
	removeIndex := 2
	result = append(result, balance[0:removeIndex]...) //ending "..." is important
	result = append(result, balance[removeIndex+1:]...)
	fmt.Printf("result is %v\n", result)


	info := make(map[string]interface{})
	info["key"] = "value"
	fmt.Println(info["key"])
	fmt.Printf("info: %#v\n", info)
	delete(info, "key")
	fmt.Printf("info: %v\n", info)

	tc := Circle{100}
	fmt.Println(GetArea(tc))
	p, q := divide(10)
	fmt.Println(p, q)
	fmt.Println(GREET)

	// for example 1
	sum := 0
	for i:= 0; i<10;i++{
		sum += i
	}
	fmt.Println(sum)
	// for example 2
	sum = 1
	for ; sum < 10; { //the init and post statement is optional
		sum += sum
	}
	fmt.Println(sum)



	if bb:=10; bb <= 10{
		fmt.Println("if test")
	}

	//		if (age <= 10){ // brace is optional
	//			fmt.Println("if test")
	//		}
	//		if (cc:= 10; cc <= 10){ // can use brace here
	//			fmt.Println("if test")
	//		}
}
func Switch(a, b int) (int, int){
	return b, a
}

func divide(sum int) (x, y int){ //named return value
	x = int(sum / 3)
	y = sum - x
	return
}
func inf_loop(){
	// for example 3
	for { // condition statement could also be omitted
		fmt.Println("infinite for loop")
		time.Sleep(time.Second * 1)
	}
}
