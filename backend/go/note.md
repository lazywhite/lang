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

module alias

```
## Keywords
```
break        default      func         interface    select
case         defer        go           map          struct
chan         else         goto         package      switch
const        fallthrough  if           range        type
continue     for          import       return       var
```
## Topic  
1. In Go, a name is exported if it begins with a capital letter  
2. When importing a package, you can refer only to its exported names. Any "unexported" names are not accessible from outside the package.  

3. extend an array
4. use 'reflect' to get type of variable
5. pointer to struct
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
