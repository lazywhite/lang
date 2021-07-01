package main

import (
	"context"
	"demo/pkg/pb"
	"fmt"
	"log"
	"net"
	"os"

	"google.golang.org/grpc"
)

type SampleServer struct{
	pb.GreetServiceServer
}

func (s *SampleServer) SayHello(ctx context.Context, req *pb.HelloRequest) (*pb.HelloResponse, error){
	name := req.GetName()
	log.Printf("received message from %s", name)
	resp :=  &pb.HelloResponse{
		Message: "hello: " + name,
	}
	return resp, nil
}


const (
	unixSockPath = "/tmp/sample.sock"
)

func logGRPC(ctx context.Context, req interface{}, info *grpc.UnaryServerInfo, handler grpc.UnaryHandler) (interface{}, error) {
	fmt.Printf("%v\n", ctx)
	fmt.Printf("%v\n", req)
	fmt.Printf("%v\n", info)
	fmt.Printf("%v\n", handler)
	resp, err := handler(ctx, req)
	if err != nil {
		log.Fatalf("GRPC error: %v\n", err)
	}
	return resp, err
}

func main(){
	//1. for tcp
    //lis, err := net.Listen("tcp", ":9090")

	//2. for unix socket
	if err := os.Remove(unixSockPath); err != nil && !os.IsNotExist(err){
		log.Fatal("remove socket error")
	}
	lis, err := net.Listen("unix", unixSockPath)

	if err != nil{
		log.Fatal("bind port error")
	}

	opts := []grpc.ServerOption{
		grpc.UnaryInterceptor(logGRPC),
	}
	s := grpc.NewServer(opts...)
	pb.RegisterGreetServiceServer(s, &SampleServer{})

	fmt.Println("serving...")
	if err = s.Serve(lis);err != nil{
		log.Fatal("serve error, %v", err)
	}
}
