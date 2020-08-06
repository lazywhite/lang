package main
import (
	"fmt"
	"time"
	"context"
)

type Student struct{
	name string
	age int
}

func main() {
	fmt.Println("vim-go")

	ctx, cancel := context.WithCancel(context.Background())
	defer cancel()

	//must be pointer
	//use struct to pass multiple value
	var st1 = &Student{
		name: "bob",
		age: 10,
	}

	valueCtx := context.WithValue(ctx, "key", st1)

	go monitor(valueCtx)

	time.Sleep(5 * time.Second)

	// update value of all goroutine
	st1.name = "alice"

	time.Sleep(5 * time.Second)


}


func monitor(ctx context.Context){
	for{
		select{
		case <-ctx.Done():
			fmt.Println("stop running")
			return
		default:
			//fmt.Println(ctx.Value("key"))
			fmt.Printf("current value: %s\n", ctx.Value("key").(*Student).name)
			time.Sleep(1 * time.Second)
		}
	}
}
