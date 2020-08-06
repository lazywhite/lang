package main
import (
	"fmt"
	"time"
	"context"
)

func main() {
	fmt.Println("vim-go")

	ctx, cancel := context.WithCancel(context.Background())

	go monitor(ctx)

	time.Sleep(5 * time.Second)
	cancel()

	time.Sleep(5 * time.Second)


}


func monitor(ctx context.Context){
	for{
		select{
		case <-ctx.Done():
			fmt.Println("stop running")
			return
		default:
			fmt.Println("running")
			time.Sleep(1 * time.Second)
		}
	}
}
