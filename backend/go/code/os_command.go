package main

import (
    "fmt"
    "os/exec"
    "bytes"
)


func exec_cmd(command string) string{
    var out bytes.Buffer
    cmd := exec.Command("bash", "-c", command)
    cmd.Stdout = &out

    err := cmd.Run()
    if err != nil{
        fmt.Println(err)
    }
    return out.String()
    
}


func main(){
    out := exec_cmd("ls -alh")
    fmt.Println(out)
}
