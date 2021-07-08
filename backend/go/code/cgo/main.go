package main

/*
#cgo CFLAGS: -g -Wall
#cgo LDFLAGS: -L. -lperson
#include "person.h"
*/
import "C"
import (
	"fmt"
)

type (
	Person C.struct_Person
)

func GetPerson(name string, long_name string) *Person {
	return (*Person)(C.get_person(C.CString(name), C.CString(long_name)))
}

func main(){
	//var p *Person
	p := GetPerson("tim", "tim hughes")
	fmt.Printf("Hello Go world: My name is %s, %s.\n", C.GoString(p.name), C.GoString(p.long_name))
}
