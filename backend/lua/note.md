## Variable type
```
nil
boolean
number
string
function
userdata
thread
table
```
## arithmetic operator
```
+ add
- subtract
* multiply
/ divid
% modulus
^ exponent
- unary
```
## relational operator
```
== equal
~= not equal
>
<
>=
<=
```
## logical operator
```
and
or
not
```
## misc operator
```
.. concatenates two string
#  get length of string
```

## Loop
```
for
while
repeat until
```
## dicision making
```
if
if else
```
## string method
```
string.upper(argument)
string.lower(argument)
string.gsub(mainString, findString, replaceString)
string.strfind(mainString, findString)
string.reverse(arg)
string.format(...) return a formated string
string.char(arg)
string.byte(arg)
string.len(arg)
string.rep(string, n)
```
## array method
## table method
## module

```
module_name = require "module_name"
module.func()
```

## metatable
metatable is a helper when modify a table   

```
setmetatable(table, metatable)  
```

metatable special method   

```
__index = function(table, index)
__newindex = function(table, key, value)
__add = function(mytable, newtable)
__sub
__mul
__div
__mod
__unm
__concat
__eq
__it
__le


__call
__tostring = function(table) --> must return a string to "print()"

```
## coroutine
```
1. coroutine are collaborative in nature, which allow two or more methods
to execute in a controlled manner, with coroutine, at any given time, only
one coroutine runs and this running coroutine only suspends its execution
when it explicitly requests to be suspended  
2. coroutine methods
coroutine.create(f) : create a corotine and return an object of type "thread"
coroutine.resume(co[, val1, ...]) :resume the coroutine and pass parameter if there is any
coroutine.running(): return the running coroutine else "nil"
coroutine.status(co): return "running", "normal", "suspended", "dead"
coroutine.wrap(f): create a coroutine, return a function which can be called to resume that coroutine
coroutine.yield(...): suspending the running coroutine

```
## File I/O
```
file = io.open(filename, [, mode])

mode: "r", "w", "a", "r+", "w+", "a+"

```
## Assertion
```
assert(boolean expression)
assert(type("hello") == string)

```
## Error handling
```
pcall(f[, arg1...]): call "f" in protected mode, if error occured in f(args), just return status, do not throw an error
xpcall(f, err_handler_f): catch the error and use "err_handler" to cleanup
```
