package main

import (
	"strings"
	"fmt"
)


func Index(vs []string, t string) int{
	for i, v := range vs{
		if v == t {
			return i
		}
	}
	return -1
}

func Include(vs []string, t string) bool{
	for _, v := range vs {
		if v == t{
			return true
		}
	}
	return false
}

func Any(vs []string, f func(string) bool) bool{
	for _, v := range vs{
		if f(v){
			return true
		}
	}
	return false
}

func All(vs []string, f func(string) bool) bool {
	for _, v := range vs{
		if !f(v){
			return false
		}
	}
	return true
}

func Filter(vs []string, f func(string) bool) []string{
	vsf := make([]string, 0)
	for _, v := range vs {
		if f(v){
			vsf = append(vsf, v)
		}
	}
	return vsf
}


func Map(vs []string, f func(string) string) []string{
	vsm := make([]string, len(vs))
	for i, v := range vs {
		vsm[i] = f(v)
	}
	return vsm
}


func main(){
	fruits := []string{"peach", "apple", "pear", "plum"}

	fmt.Println("index of pear in fruits:", Index(fruits, "pear"))
	fmt.Println("fruits contains grape:", Include(fruits, "grape"))
	fmt.Println("has fruits member starts with p:", Any(fruits, func(v string) bool{
		return  strings.HasPrefix(v, "p")
	}))
	fmt.Println("fruits name all starts with p:", All(fruits, func(v string) bool{
		return strings.HasPrefix(v, "p")
	}))

	fmt.Println("filtered fruits name contains e:", Filter(fruits, func(v string) bool{
		return strings.Contains(v, "e")
	}))
	fmt.Println(Map(fruits, strings.ToUpper))

}
