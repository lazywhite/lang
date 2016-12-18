package main

import "fmt"
type MyStruct struct{
	X, Y int
}

func main(){
	var a int = 10
	var p *int = &a  //a pointer to an int
	var q **int = &p //pointer to pointer
	ms := MyStruct{10, 20}

	var ps *MyStruct = &ms
	fmt.Println(p)
	fmt.Println(*p)
	fmt.Println(q)
	fmt.Println(*q)
	fmt.Println(**q)
	fmt.Println("address of ps:",ps)
	fmt.Println(ps.X, ps.Y)
	fmt.Println(ms.X, ms.Y)

}
