package main


import (
	"strconv"
	"fmt"
)

var p = fmt.Println

func main(){
	f, _ := strconv.ParseFloat("1.23", 64)
	p(f)

	i, _ := strconv.ParseInt("123", 0, 64) // 0 means automatically type infer, 64 specify the bit of precision
	p(i)

	d, _ := strconv.ParseInt("0x1c8", 0, 64) // hexo number can be recognized
	p(d)

	u, _ := strconv.ParseUint("7898", 0, 64)
	p(u)

	k, _ := strconv.Atoi("138")
	p(k)

	_, e := strconv.Atoi("wat")
	fmt.Println(e)
}
