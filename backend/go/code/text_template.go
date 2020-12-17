package main


import (
	"text/template"
	"fmt"
	"bytes"
)

type Args struct{
	Name string
}

func main(){

	arg := &Args{"Bob"}
	output := new(bytes.Buffer)

	str := "hello {{ .Name }}"

	tpl, err := template.New("test").Parse(str)
	if err != nil{
		panic(err.Error())
	}
	tpl.Execute(output, arg) 
	if err != nil{
		panic(err.Error())
	}
	fmt.Println(output.String())

}
