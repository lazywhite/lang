package demo


import (
    "github.com/prashantv/gostub"
    "testing"
    "fmt"
    //"errors"
)



func TestGreetInfo(t *testing.T){
    stb := gostub.Stub(&Name, "alice")
    defer stb.Reset()
    fmt.Println(GreetInfo(Name))
}

func TestToString(t *testing.T){
    s := Student{
        Name: "bob",
        Age: 10,
    }
    fmt.Println(s.ToString())

    stb := gostub.StubFunc(&Marshal, []byte(`{"Name": "haha", "Age": 10}`), nil)

    fmt.Println(s.ToString())
    stb.Reset()

    /*  
    抛出错误
    stb = gostub.StubFunc(&Marshal, nil, errors.New("a error"))
    s.ToString()
    stb.Reset()
    */
}


func TestGreeting(t *testing.T){
    greeting()
    stb := gostub.Stub(&greeting, func(){
        fmt.Println("not good")
    })
    defer stb.Reset()
    greeting()
}
