package main

import "text/template"

import "os"

type Inventory struct {
	Meterial string
	Count    uint
}

func main() {
	sweaters := Inventory{"wool", 17}

	tmpl, err := template.New("test").Parse("{{.Count}} items are made of {{.Meterial}}")
	if err != nil {
		panic(err)
	}

	err = tmpl.Execute(os.Stdout, sweaters)
	if err != nil {
		panic(err)
	}

}
