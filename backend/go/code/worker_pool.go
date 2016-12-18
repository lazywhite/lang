package main
import "fmt"
import "time"

/*
when using channels as function parameters, you can specify if a channel
is meant to only send or receive values

channel direction
*/

var pool_size int = 4
func worker(id int, jobs <-chan int, results chan<- int){ //jobs is a channel only used for receiving data, results is a channel only used to sending data

//	fmt.Println(id)
	for j:= range jobs{
		fmt.Println("worker", id, "processing jobs", j)
		time.Sleep(time.Second * 3)
		results <- j * 2
	}
}


func main(){
	jobs := make(chan int, 100)
	results := make(chan int, 100)

	for w := 1; w <= pool_size; w++{
		go worker(w, jobs, results)
	}

	for j:=1; j<=9; j++{
		jobs <- j
	}

	close(jobs)
	for a:=1 ; a<=9; a++{
//		data := <-results
//		fmt.Println(data)
		<-results
	}
}
