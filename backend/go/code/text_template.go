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

	output := new(bytes.Buffer)
	//arg := &Args{"Bob"}
	//str := "hello {{ .Name }}"
	arg := "/tmp/abc.txt"
	str := "path: {{.}}"


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
