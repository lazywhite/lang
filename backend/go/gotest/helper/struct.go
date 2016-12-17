package helper
import "fmt"
import "math"

type Child struct{
	Name string
	Age int
}

type Circle struct{
	Radius int
}

func (c Circle) Area() float32{
	return float32(c.Radius) * float32(c.Radius) * math.Pi
}

func init(){
	fmt.Println("struct initialized")
}
