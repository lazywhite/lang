package main
import (
	"syscall"
	"os"
	"os/exec"
)

/* by replacing current process to get result, not spawning new process
*/

func main(){
	binary, _ := exec.LookPath("ls")
	args := []string{"list current path", "-alh"} //first element is program name
	env := os.Environ()

	execErr := syscall.Exec(binary, args, env)

	if execErr != nil{
		panic(execErr)
	}

}
