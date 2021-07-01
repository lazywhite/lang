package main

import (
	"context"
	"fmt"
	"google.golang.org/grpc"
	"log"
	"time"

	"demo/pkg/pb"
)

const(
	addr = "localhost:9090"
)

func main(){
	conn, err := grpc.Dial(addr, grpc.WithInsecure(), grpc.WithBlock())
	if err != nil{
		log.Fatal("failed to connect server")
	}
	defer conn.Close()

	c := pb.NewGreetServiceClient(conn)
	ctx, cancel := context.WithTimeout(context.Background(), time.Second)
	defer cancel()
	r, err := c.SayHello(ctx, &pb.HelloRequest{Name: "bob"})
	if err != nil{
		log.Fatal("rpc call error")
	}
	fmt.Println(r.GetMessage())
}