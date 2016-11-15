## Introduction
静态强类型， 编译型， 并发型， 自动垃圾回收 
## Key concept
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
12. range keyword to iterater over containers
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
40. type rune
41. better not use global variable, hard to test, use 
I would pass it as a function param, or make it a struct method. Global variable is not very pragmatic for that even though it might seem so, a common way to do that is to define methods on a struct instead and keep the state there.
42. do anything in goroutine and return the value over the channel
43. import "path/to/dir"  dir have random package name is supported
44. pass struct as arguments
45. go get time time of execution
46. godoc <module> <function>
47. Lexical tokens are enclosed in double quotes "" or back quotes ``
