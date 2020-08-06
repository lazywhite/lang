package main

import (
	"fmt"
	"context"
	"time"
)


func main(){

	ctx, cancel := context.WithTimeout(context.Background(), 5 * time.Second)

	defer cancel()
	go monitor(ctx)

	time.Sleep(10 * time.Second)


}


func monitor(ctx context.Context){
	for{
		select{
		case <-ctx.Done():
			fmt.Println("exiting")
			return
		default:
			fmt.Println("running")
			time.Sleep(1 * time.Second)
		}
	}
}
