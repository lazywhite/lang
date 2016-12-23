package main

import (
	"fmt"
	"sort"
)

func main(){
	strs := []string{"cavil", "alic", "bob"}

	sort.Strings(strs)
	fmt.Println("Strings:", strs)


	ints := []int{7, 3, 2}
	sort.Ints(ints)
	i := sort.IntsAreSorted(ints)
	fmt.Println("Ints:", ints)
	fmt.Println("IntsAreSorted:", i)

	s := sort.IntsAreSorted(ints)
	fmt.Println("StringsAreSorted", s)

	mints := []int{4, 2, 8}
	sort.Sort(sort.Reverse(sort.IntSlice(mints))) //reverse sort
	fmt.Println(mints)

}
