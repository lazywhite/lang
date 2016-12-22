package main

import (
	"net"
	"fmt"
	"time"
	"os"
)

var server  string = "localhost:4321"

func main(){
	tcpAddr, err := net.ResolveTCPAddr("tcp4", server)
	checkError(err)

	conn, err := net.DialTCP("tcp", nil, tcpAddr)
	checkError(err)

	ticker := time.NewTicker(time.Millisecond * 1000)
	defer ticker.Stop()

	for t := range ticker.C {
		fmt.Println("Tick at", t)
		sendMsg(conn)
	}
}

func sendMsg(conn net.Conn){
	words := "hello world"
	conn.Write([]byte(words))
	fmt.Println("message sended")
}

func checkError(err error){
	if err != nil {
		fmt.Fprintf(os.Stderr, "Fatal error: %s", err.Error())
	}

}
