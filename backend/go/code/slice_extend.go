package  main

import "fmt"

func main(){
	a := []int{1, 2, 3}
	b := []int{1, 2, 3}

	a = append(a, b...)
	fmt.Println(a)
}