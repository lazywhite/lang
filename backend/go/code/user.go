package main
import (
	"os/user"
	"fmt"
	"reflect"
)


func main(){
	u, err := user.Current()
	if err != nil{
		panic(err)
	}

	fmt.Println(reflect.TypeOf(u))
	fmt.Println(u.Name)
	fmt.Println(u.Username)
	fmt.Println(u.Uid)
	fmt.Println(u.Gid)
	fmt.Println(u.HomeDir)
}
