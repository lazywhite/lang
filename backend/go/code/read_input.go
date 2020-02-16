//
// read_input.go
// Copyright (C) 2020 white <white@Whites-Mac-Air.local>
//
// Distributed under terms of the MIT license.
//

package main

import (
    "fmt"
)
func main(){
   // var i int
   // fmt.Scanf("%d", &i)
   // fmt.Printf("get input: %d\n", i)

   // 输入不能包含空格
   var i string
   fmt.Scanf("%s", &i)
   fmt.Printf("get input: %s\n", i)

   // 输入不能包含空格
   // var line string
   // fmt.Scanln(&line)
   // fmt.Printf("get input: %s\n", line)

   // 输入不能包含空格
   // var line string
   // fmt.Scan(&line)
   // fmt.Printf("get input: %s\n", line)
}
