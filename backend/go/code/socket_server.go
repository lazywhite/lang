package main
import (
	"net"
	"os"
	"log"
	"fmt"
)

/*
* goroutine based socket server
*/

func main(){
	netListen, err := net.Listen("tcp", "localhost:4321")
	CheckError(err)

	defer netListen.Close()
	Log("Waiting for connection")
	for {
		conn, err := netListen.Accept()
		if err != nil{
			continue
		}

		Log(conn.RemoteAddr().String(), "tcp connect success")
		go handleConnection(conn)
	}
}

func CheckError(err error){
	if err != nil{
		fmt.Fprintf(os.Stderr, "fatal error: %s", err.Error())
		os.Exit(1)
	}
}

func Log(v ...interface{}){
	log.Println(v...)
}

func handleConnection(conn net.Conn){
	buffer := make([]byte, 2048)
	for {
		n, err := conn.Read(buffer)
		if err != nil {
			Log(conn.RemoteAddr().String(), " connection error: ", err)
			return
		}
		Log(conn.RemoteAddr().String(), "receive data string:\n" , string(buffer[:n]))
	}
}
