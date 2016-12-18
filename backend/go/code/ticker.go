package main
import "time"
import "fmt"
/*
	used for doing job repeately at regular intervals
*/
func main(){
	ticker := time.NewTicker(time.Millisecond * 500)
	go func(){
		for t := range ticker.C {
			fmt.Println("Tick at", t)
		}
	}()

	time.Sleep(time.Millisecond * 1600)
	ticker.Stop()
	fmt.Println("Ticker stopped")
}
