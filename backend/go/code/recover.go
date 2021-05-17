package main

import (
  "fmt"
)

func foo(){
  defer func(){
      if err := recover(); err != nil {
          fmt.Println(err)
      }
      fmt.Println("recovered from panic")
  }()
  var bar *int
  fmt.Println(*bar)
}

func main(){
  foo()
  fmt.Println("If not recovered, this line will not be printed")
}
