package main

import (
	"demo/db"
	"fmt"
)

func main(){
	repo := db.MysqlRepo{
		Host: "localhost",
		Port: 3306,
	}
	client := db.NewMySQL(&repo)
	v, err := client.GetData("test")
	if err != nil{
		panic("failed to get data")
	}
	fmt.Println(string(v))
}