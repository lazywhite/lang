package main

import (
	"flag"
	"fmt"
)
/*
* go run cli_flag.go -h
* go run cli_flag.go -word=opt -numb=7 -fork -svar=flag
* go run cli_flag.go -word=opt 
* go run cli_flag.go --fork true
* go run cli_flag.go --numb 78 --word kick  --fork=true --svar=ksjdf a d d g
*/

func main(){
	wordPtr := flag.String("word", "foo", "a string")
	numbPtr := flag.Int("numb", 42, "an int")
	boolPtr := flag.Bool("fork", false, "a bool")
	var svar string
	flag.StringVar(&svar, "svar", "bar", "a string var")

	flag.Parse()

	fmt.Println("word: ", *wordPtr)
	fmt.Println("numb: ", *numbPtr)
	fmt.Println("fork: ", *boolPtr)
	fmt.Println("svar: ", svar)
	fmt.Println("tail: ", flag.Args())
}

