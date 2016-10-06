package main

import "fmt"
import "os/exec"

func main() {
	var cmd string
	cmd = "echo 'system command get called'"
	out, err := exec.Command("sh", "-c", cmd).Output()
	if err != nil {
		fmt.Printf("%s", err)
	}
	fmt.Printf("%s", out)

}
