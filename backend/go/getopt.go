package main

import . "github.com/mattn/go-getopt"
import "os"
import "fmt"

func main() {
	var c int
	for {
		if c = Getopt("dc:h"); c == EOF {
			break
		}
		switch c {
		case 'd':
			fmt.Println("daemon")
		case 'c':
			fmt.Printf("config: %s", OptArg)
		case 'h':
			fmt.Println("Usage : ./main -c </path/to/config> -d")
			os.Exit(1)
		}
	}

	for n := OptInd; n < len(os.Args); n++ {
		println(os.Args[n])
	}

}
