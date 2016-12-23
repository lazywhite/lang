package main

import (
	"sort"
	"fmt"
)

type ByLength []string
/*
by implementing sort.Interface: (Len, Less, Swap), we can use sort.Sort()
to do customized sort.
*/

func (s ByLength) Len() int{
	return len(s)
}


func (s ByLength) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}

func (s ByLength) Less(i, j int) bool {
	return len(s[i]) < len(s[j])
}


func main(){
	fruits := []string{"peach", "banana", "kiwi"}
	sort.Sort(ByLength(fruits))

	fmt.Println(fruits)
}
