package main

import (
	"bou.ke/monkey"
	"fmt"
	"reflect"
)

type Student struct {
	Name string
}

func (s *Student) Greet(){
	fmt.Printf("I'm %s\n", s.Name)
}

func main() {
	s := &Student{"bob"}
	s.Greet()

	//var s *Student
	monkey.PatchInstanceMethod(reflect.TypeOf(s), "Greet", func(_ *Student){
		fmt.Println("hehe")
	})

	s.Greet()
	monkey.UnpatchAll()
}
