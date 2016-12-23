package main

import (
	"encoding/json"
	"fmt"
	"os"
)


type Response1 struct{
	Page int "may be"
	Fruits []string
}

type Response2 struct{
	Page int  `json:"page"` //field tag
	Fruits []string `json:"fruits"` //customized the json key name
}

/*
json.Marshal(interface{}) transfer basic go data types to json string
json.UnMarshal() convert json string to built-in or referenced data types 
*/

func main(){
	bolB, _ := json.Marshal(true)
	fmt.Println(string(bolB))

	intB, _ := json.Marshal(1)
	fmt.Println(string(intB))

	fltB, _ := json.Marshal(2.34)
	fmt.Println(string(fltB))

	strB, _ := json.Marshal("gopher")
	fmt.Println(string(strB))

	slicD := []string{"apple", "orange", "banana"}
	slicB, _ := json.Marshal(slicD)
	fmt.Println(string(slicB))

	mapD := map[string]int{"apple": 5, "orange": 6}
	mapB, _ := json.Marshal(mapD)
	fmt.Println(string(mapB))


	res1D := &Response1{
		Page: 1,
		Fruits: []string{"apple", "peach", "pear"}, //comma is required here
	}
	res1B, _ := json.Marshal(res1D)
	fmt.Println(string(res1B))

	res2D := &Response2{
		Page: 1,
		Fruits: []string{"apple", "peach", "pear"},
	}
	res2B, _ := json.Marshal(res2D)
	fmt.Println(string(res2B))

	byt := []byte(`{"num":6.13,"strs":["a","b"]}`) //using round bracket not curly bracket

	var dat map[string]interface{}

	if err := json.Unmarshal(byt, &dat); err != nil{ //unpacking json to map
		panic(err)
	}
	fmt.Println(dat)
	num := dat["num"].(float64) //type assertion
	fmt.Println(num)


	str := `{"page":1, "fruits":["apple", "peach"]}`
	res := Response2{}
	json.Unmarshal([]byte(str), &res) //unpacking json to struct
	fmt.Println(res)
	fmt.Println(res.Fruits[0])
	enc := json.NewEncoder(os.Stdout) //no intermedia storage is required, json is directly output to os.Stdout
	d := map[string]int{"apple":5, "orange":8}
	enc.Encode(d)

}

