package app
import (
    "fmt"
)

func Greet(name string){
    fmt.Printf("hello %s\n", name)
}


func FullName(firstName, lastName string) string{
    return fmt.Sprintf("%s %s", firstName, lastName)
}
