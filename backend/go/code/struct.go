package main

import "fmt"

type Book struct {
	title  string
	author string
	price  float64
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

}
