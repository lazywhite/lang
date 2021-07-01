package main

import (
	"context"
	"demo/pkg/pb"
	"log"
	"net"

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



func main(){
    lis, err := net.Listen("tcp", ":9090")
	if err != nil{
		log.Fatal("bind port error")
	}
	s := grpc.NewServer()
	pb.RegisterGreetServiceServer(s, &SampleServer{})

	if err = s.Serve(lis);err != nil{
		log.Fatal("serve error, %v", err)
	}
}
