package main

import (
	"fmt"
	"reflect"
)

/*
field tag
	definition
	access field tag of a struct by using "reflect"
*/
type Book struct {
	title  string
	author string
	price  float64
	desc string `category:"war" color:"blue"`
}

func main() {
	var b = Book{
		title:  "Lomo",
		author: "Benjam",
		price:  17.08,
	}

	fmt.Printf("Title: %s, Author: %s, Price: %.2f\n",
		b.title,
		b.author,
		b.price)
	st := reflect.TypeOf(b)
	field := st.Field(3)
	fmt.Println(field.Tag.Get("category"), field.Tag.Get("color"))

}
