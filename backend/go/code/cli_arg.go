package main

import "fmt"
import "os"
import "reflect"

func main() {
	fmt.Println(reflect.TypeOf(os.Args))
	fmt.Println(os.Args) // arguments with program name
	fmt.Println(os.Args[1:]) //arguments without program name
}
