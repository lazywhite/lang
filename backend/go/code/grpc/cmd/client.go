package main

import (
	"context"
	"fmt"
	"google.golang.org/grpc"
	"log"
	"net"
	"time"

	"demo/pkg/pb"
)

const (
	sockPath = "/tmp/sample.sock"
)

func main(){
	//1. for tcp
	//conn, err := grpc.Dial("localhost:9090", grpc.WithInsecure(), grpc.WithBlock())

	//2. for unix socket
	conn, err := grpc.Dial(sockPath,
		grpc.WithInsecure(),
		grpc.WithContextDialer(func(context.Context, string)(net.Conn, error){
			addr, err := net.ResolveUnixAddr("unix", sockPath)
			conn, err := net.DialUnix("unix", nil, addr)
			return conn, err
		}))
	defer conn.Close()

	//c := pb.NewGreetServiceClient(conn)
	c := pb.NewGreetServiceClient(conn)
	ctx, cancel := context.WithTimeout(context.Background(), time.Second)
	defer cancel()
	r, err := c.SayHello(ctx, &pb.HelloRequest{Name: "bob"})
	if err != nil{
		log.Fatal("rpc call error")
	}
	fmt.Println(r.GetMessage())
}