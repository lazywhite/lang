package main

import (
	"fmt"
	"bytes"

	"gopkg.in/yaml.v3"
)

type (
	T struct {
		A string
		B string
	}
)

func Parse(source []byte) (err error) {
	dec := yaml.NewDecoder(bytes.NewReader(source))

	for {
		doc := new(T)
		if dec.Decode(doc) != nil  {
			break
		}
		fmt.Println(doc)
	}

	return
}

func main() {
	s:=`---
a: val a
---
b: val b
---`
	Parse([]byte(s))
}
