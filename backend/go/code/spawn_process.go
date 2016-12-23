package main

import (
	"fmt"
	"os/exec"
	"io/ioutil"
)
/*
by creating an external process to get the result 
*/

func main(){
	dateCmd := exec.Command("date")
	dateOut, _ := dateCmd.Output()

	fmt.Println(string(dateOut))


	grepCmd := exec.Command("grep", "hello")

	grepIn, _ := grepCmd.StdinPipe()
	grepOut, _ := grepCmd.StdoutPipe()
	grepCmd.Start()
	grepIn.Write([]byte("hello grep\ngoodbye grep"))
	grepIn.Close()
	grepBytes, _ := ioutil.ReadAll(grepOut)
	grepCmd.Wait()
	fmt.Println(">grep hello")
	fmt.Println(string(grepBytes))

	lsCmd := exec.Command("bash", "-c", "ls -alh")
	lsOut, err := lsCmd.Output()
	if  err != nil{
		panic(err)
	}
	fmt.Println("> ls -alh")	
	fmt.Println(string(lsOut))
}
