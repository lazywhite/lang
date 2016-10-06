package main

import "fmt"

func main() {
	var a, b int = 10, 20
	var p *int // declare a pointer
	var q **int
	// if a pointer is declared but not used, it's a "nil" pointer
	var ptr [2]*int
	ptr[0] = &a
	ptr[1] = &b
	p = &b
	q = &p
	fmt.Printf("the address of variable a is %x\n", &a)
	fmt.Printf("the value of pointer p is %d\n", *p)
	fmt.Printf("address of item %x\n", ptr[0])
	fmt.Printf("address of item %x\n", ptr[1])
	fmt.Printf("value of pointer to pointer q %d\n", **q)
}
