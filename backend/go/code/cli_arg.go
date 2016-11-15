package main

import "fmt"
import "os"
import "reflect"

func main() {
	fmt.Println("vim-go")
	fmt.Println(reflect.TypeOf(os.Args))
	fmt.Println(os.Args)
	fmt.Println(os.Args[1:])
}
