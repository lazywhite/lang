package main



import (
	"os/exec"
	"fmt"
)

func main(){
	cmd := exec.Command("bash", "-c", "sleep 1; echo", "good")
	err := cmd.Run()
	if err != nil{
		fmt.Println(err.Error())
	}
}
