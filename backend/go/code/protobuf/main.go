package main

import (
	"fmt"
	"log"
	"time"

	"demo/pkg/pb"
	"google.golang.org/protobuf/proto"
	"google.golang.org/protobuf/types/known/timestamppb"
)

func main(){
	age := int32(12)
	s := &pb.Student{
		Name:        "bob",
		Age:         &age,
		Phone:       []*pb.PhoneNumber{
			{
				Number: "13017231412",
				Type:   pb.PhoneNumber_Mobile,
			},

		},
		Follower:    &pb.Student_Follower{
			Youtube: 100,
			Twitter: 200,
		},
		LastUpdated: &timestamppb.Timestamp{
			Seconds: time.Now().Unix(),
		},
	}

	book := &pb.AddressBook{
		Student: []*pb.Student{
			s,
		},
	}

	data, err := proto.Marshal(book)
	if err != nil{
		log.Fatalf("pb marshal error: %v", err)
	}

	fmt.Println(data)

	book2 := new(pb.AddressBook)

	err = proto.Unmarshal(data, book2)
	if err != nil{
		log.Fatalf("pb unmarshal error: %v", err)
	}

	for _, stu := range book2.Student{
		fmt.Println(stu.GetName())
		fmt.Println("student: %v", stu)
	}
}