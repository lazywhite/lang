package main


import (
	"fmt"
	"crypto/sha1"
	"crypto/md5"
)
/*
[]byte(s string): convert a string to []byte

h.Sum(s []byte): the hash result can be appended to an existing byte slice
				is usually isn't needed
*/
func main(){
	s := "sha1 this string"
	h := sha1.New()
	h.Write([]byte(s))
	bs := h.Sum(nil) //
	fmt.Println(bs) //SHA1 value are offen printed in hex 
	fmt.Printf("%x\n", bs)


	m := md5.New()
	m.Write([]byte(s))
	mm := m.Sum(nil)
	fmt.Println(mm) //SHA1 value are offen printed in hex 
	fmt.Printf("%x\n", mm)
}
