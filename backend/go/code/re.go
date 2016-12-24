package main

import (
	"bytes"
	"fmt"
	"regexp"
	"strings"
)


func main(){
	match, _ := regexp.MatchString("p([a-z]+)ch", "peach")
	target := "peach punch"
	fmt.Println("1", match)

	r, _ := regexp.Compile("p([a-z]+)ch")

	fmt.Println("2", r)
	fmt.Println("3", r.MatchString("peach"))
	fmt.Println("4", r.FindString(target))

	fmt.Println("5", r.FindStringIndex(target))

	fmt.Println("6", r.FindStringSubmatch(target))

	fmt.Println("7", r.FindStringSubmatchIndex(target))

	fmt.Println("8", r.FindAllString("peach punch pinch", -1))

	fmt.Println("9", r.FindAllStringSubmatchIndex("peach punch pinch", -1))

	fmt.Println("10", r.FindAllString("peach punch pinch", 2))

	fmt.Println("11", r.Match([]byte("peach")))

	r = regexp.MustCompile("p([a-z]+)ch")
	fmt.Println("12", r)


	fmt.Println("13", r.ReplaceAllString("a peach, a punch, a pinch", "<fruit>"))

	in := []byte("a peach")
	out := r.ReplaceAllFunc(in, bytes.ToUpper)
	mout := r.ReplaceAllFunc(in, Capital)
	fmt.Println("14", string(out))
	fmt.Println("15", string(mout))
}


func Capital(ba []byte) []byte{ //self defined func for r.ReplaceAllFunc(ba []byte, f func(ba []byte) []byte)
	s := string(ba)
	s = strings.ToLower(s)
	ba = []byte(s)
	ba[0] -= 32
	return ba
}
