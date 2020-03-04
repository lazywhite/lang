//
// string_split.go
// Copyright (C) 2020 white <white@Whites-Mac-Air.local>
//
// Distributed under terms of the MIT license.
//

package main

import (
    "fmt"
    "strings"
)

func main() {
    s := strings.Split("127.0.0.1:5432", ":")
    ip, port := s[0], s[1]
    fmt.Println(ip, port)
}
