//
// switch.go
// Copyright (C) 2020 white <white@bogon>
//
// Distributed under terms of the MIT license.
//

package main
import "fmt"

func catNumber(i int){
    switch i {
        case 0:
            fmt.Println("0")
        case 1:
            fmt.Println("1")
        case 2:
            fallthrough
        case 3:
            fmt.Println("3")
        case 4, 5, 6:
            fmt.Println("4, 5, 6")
        default:
            fmt.Println("Default")
    }
}

func deNumber(Num int){
    switch {
    case 0 <= Num && Num <= 3:
        fmt.Println("0-3")
    case 4 <= Num && Num <= 6:
        fmt.Println("4-6")
    case 7 <= Num && Num <= 9:
        fmt.Println("7-9")
    default:
        fmt.Println("bigger than 9")
    }
}

func main(){
    a := []int{1, 2, 3, 4, 8, 10}
    for _, i := range a{
        catNumber(i)
    }
    for _, i := range a{
        deNumber(i)
    }
}
