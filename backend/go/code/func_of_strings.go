package main


import (
	s "strings" //module alias
	"fmt"
)

var p = fmt.Println // func alias
var c rune //just like "int32"

var str string = `"string using back quote",  it is a better way to define a string contains double quote `

var str2 string = `you cant escape` + " ` " + `"back quote"`

func main(){
	//c = "A"//can't assign with "string"
	c = 65
	p("Contains: ", s.Contains("test", "es"))
	p("Count: ", s.Count("test", "t"))
	p("HasPrefix: ", s.HasPrefix("test", "te"))
	p("HasSuffix: ", s.HasSuffix("test", "st"))
	p("Index: ", s.Index("test", "t"))
	p("Join: ", s.Join([]string{"a", "b"}, "-"))
	p("Repeat: ", s.Repeat("a", 5))
	p("Replace: ", s.Replace("foo", "o", "0", -1))
	p("Replace: ", s.Replace("foo", "o", "0", 1))
	p("Split: ", s.Split("a-b-c-d", "-")) //return an array
	p("ToLower: ", s.ToLower("TEST"))
	p("ToUpper: ", s.ToUpper("test"))
	p("Len: ", len("test"))
	p("Char: ", string("hello"[0]))
	p(SwapRune('a')) 
	p(str)
	p(str2)

}

func SwapRune(r rune) rune{ //param type is rune, when passing a char
				// it will be transfered to unicode codepoint of ASCII 
	switch {
	case 97 <= r && r<=122:
		return r - 32
	case 65 <= r && r<= 90:
		return r + 32
	default:
		return r
	}
}
