package main

import (
	"fmt"
	"sort"
)

'''
默认支持[]int, []string, []float slice排序支持
'''

type Student struct{
	Name string
	Age int
}

type StudentList []Student

func (s StudentList) Swap(i, j int){
	s[i], s[j] = s[j], s[i]
}

func (s StudentList) Less(i, j int) bool{
	return s[i].Age < s[j].Age
}

func (s StudentList) Len() int{
	return len(s)
}

func main() {
	fmt.Println("vim-go")
	s1 := &StudentList{
		{"alice", 10},
		{"ib", 20},
		{"ace", 7},
		{"lice", 13},
	}
	fmt.Println(s1)
	sort.Sort(s1)
	fmt.Println(s1)
}
