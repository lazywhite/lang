//
// slice_variadic_input.go
// Copyright (C) 2020 white <white@Whites-Mac-Air.local>
//
// Distributed under terms of the MIT license.
//

package main

import (
    "fmt"
    "os/exec"
)

func main() {
    name := "echo"
    args := []string{"hello", "world"}
    cmd := exec.Command(name, args...)
    out, err := cmd.Output()
    if err != nil {
        fmt.Println(err)
    }
    fmt.Println(string(out))
}
