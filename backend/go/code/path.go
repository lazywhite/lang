package main

import (
	"fmt"
	"path/filepath"
	"os"
	"log"
)

func main(){
	dir, err := filepath.Abs(filepath.Dir(os.Args[0]))
	if err != nil{
		log.Fatal(err)
		panic(err)
	}
	log.Fatal("this is fatal error")
	fmt.Println(dir)
}
