## get
-d: do not install it after downloading source code


## test
test package 

## doc
show documentation for package or symbol

## generate
generate Go files by processing source

## run 
compile and run Go programm


## version
print Go version

## fmt
run gofmt on package source   
-n: prints commands that would be executed  
-x: prints commands as they are executed  

## fix
run go tool fix on package


## env 
print Go environment information

## clean 
remove object files


## build
compile packages and dependencies

## list
list packages

## help
go help gopath


## get help information
```
1. https://godoc.org/  
2. go doc <package> [func]  
3. godoc -http :6060  
```

## go doc
```
1. go doc <pkg-FQDN>
2. 要想有web页面，需要安装godoc工具
go get -v  golang.org/x/tools/cmd/godoc
godoc -http :8000 github.com/lazywhite/samplecontroller
```
