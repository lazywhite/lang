//
// fileLogger.go
// Copyright (C) 2020 white <white@Whites-Mac-Air.local>
//
// Distributed under terms of the MIT license.
//

package main

import (
    "log"
    "os"
)
func main(){
   f, err := os.OpenFile("text.log",
	os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
    if err != nil {
        log.Println(err)
    }
    defer f.Close()

    logger := log.New(f, "prefix", log.LstdFlags)
    logger.Println("text to append")
    logger.Println("more text to append") 
}
