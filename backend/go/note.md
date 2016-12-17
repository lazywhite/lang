## Introduction
静态强类型， 编译型， 并发型， 自动垃圾回收   
  
1. no support for type inherience
2. no support for method or operator overloading
3. no support for circular dependencies among packages
4. no support for pointer arithmetic
5. no support for assertion
6. no support for generic programming
7. support for type inference \(short assignment\)
8. compilation is fast
9. conciseness simplicity and safety
10. support for interface and type embedding
11. production of statically linked native binaries without external dependency

## Concept
```
variable
function
receiver
defer
interface
array
slice
map
structure
pointer
channel
range

recursion
type casting
error handling
```
## Keywords
```
break        default      func         interface    select case         defer        go           map          struct
chan         else         goto         package      switch
const        fallthrough  if           range        type
continue     for          import       return       var
```
## Triple dot
```
1.  go list ./...   in any folder lists all the packages, including packages of the standard library first followed by external libraries in your go workspace.
2.  a := make([]int, 500)    
SomeVariadicFunc(a...)  unpacking "a" as the arguments to a function
3.  b := [...]int{1,2,3}  "..." is evaluated to size of array in compile time
4. SomeVariadicFunc(a ...int)  define a variadic function
```  
## Format output
```
%v: the value in a default format
%+v: when printing structs, the plus flag adds field names 
%#v: a go-syntax representation of the value
%T: a go-syntax representation of the type of the value 
%%: a literal percent sign
%t: the word true of false
%b: base 2 
%d: base 10 
%o: base 8 
%c: the character 
%x: base 16, with lower-case letters for a-f
%X: base 16, with upper-case letters for A-F
%U: Unicode format: U+1234; same as "U+%04X"
%f: decimal point but no exponent
%s: the uninterpreted bytes of the string or slice
%q: a double-quoted string safely escaped with Go syntax
%p: base 16 notation, with leading 0x
```

## Topic  
1. In Go, a name is exported if it begins with a capital letter  
2. When importing a package, you can refer only to its exported names. Any "unexported" names are not accessible from outside the package.  

3. extend an array
4. use 'reflect' to get type of variable
5. pointer to structure
6. no generic method
7. interface implement is implicit
8. package directory hierachy
9. module alias
10. import number of modules
11. make() to create array, map
12. range keyword to iterater over containers like "array" and "map"
13. interface{} stand for any type
14. import path conflict with standard library will get a  compile error of "redeclaration"
15. import . "<pkg>"
16. import _ "<pkg>" solely for side effect, call init() only, a package can have multiple init()
    the order of calling is the lexical order of the filenames. multi init() in same "go" file 
    will get called by their source code order
17. compile a package will not recursive
18. error handling 
19. "goto" keyword
20. pointer to array
21. pointer arthmetic is not supported in Go
22. string template
23. time.Sleep()
24. calling between Go and C
25. buildmode
26. testflag, testfunc
27. standard library source code in $GOROOT/src
28. 交叉编译  CGO_ENABLED=0 GOOS=linux|darwin|windows GOARCH=amd64 
29. path/filepath
30. io/ioutil 
31. flag, os.Args
32. fallthrough: no break and execute next case forcefully
33. Maps are reference types, so they are allways passed by reference. You don't need a pointer.
34. A "go" statement starts the execution of a function call as an independent concurrent thread of control, or goroutine, within the same address space. 
35. TOML: Tom's Obvious, Minimal Language
36. getopt
37. struct  only fields starting with a capital letter are exported
38. string concate
39. log package
40. type rune: just like "int32", is used to distinguish charactor value from integer, when fmt.Println(m rune), it always output a number, m can be a char
41. better not use global variable, hard to test, use 
I would pass it as a function param, or make it a struct method. Global variable is not very pragmatic for that even though it might seem so, a common way to do that is to define methods on a struct instead and keep the state there.
42. do anything in goroutine and return the value over the channel
43. import "path/to/dir"  "package name" can be different from "dir name"
44. pass struct as arguments
45. go get time time of execution
46. godoc <module> <function>
47. Lexical tokens are enclosed in double quotes "" or back quotes ``
48. import  "module",  every "init() of Go file" under that directory is called, without "sub_directories"
49. error handling in Go, "error" type
50. "* \<type>" define a pointer to "\<type>" , "&\<var>" get the pointer of <var>
51. "revel" go webframework  
52. "regexp" module
53. "strconv" conversions to and from "string" between "other data types"
54. import "os/exec"; exec.Command("")
56. "path/filepath"  
57. "uintptr" type is an integer type that is large enough to hold the bit pattern of any pointer  
58. "label" and "goto"
59. no "interpreter" interface in go
60. "GOPATH"  just like "PATH", you can have a list of "GOPATH"
61. append(), cap(), delete(), len()
62. when multiply different type of data, you should convert them to same type firstly
63. if you use same rand.Seed(<number>), you will get a same rand.Intn(<number>)
64. named return value, use return variable in function and just return
65. short assignment is not available outside "func" body
66. zero value: 0 for numeric types, false for boolean type and "" for string, "nil" for slice, "nil" for map
67. const cannot be declared by using short assignment
68. when declaring a const, type could be omitted
69. you cannot define a function inside a function in Go
70. slice could contain any type, include other slices
71. you can skip the index or value by assigning to "_"
