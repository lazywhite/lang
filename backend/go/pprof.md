```
1. 改造代码  
## app.go

package main

import (
    "log"
    "net/http"
    _ "net/http/pprof"
)

func main() {
    go func(){
    	http.ListenAndServe("0.0.0.0:6060", nil)
	}()

	//long run job
}
2. go run app.go
3. 各指标页面
    cpu（CPU Profiling）: $HOST/debug/pprof/profile，默认进行 30s 的 CPU Profiling，得到一个分析用的 profile 文件
    block（Block Profiling）：$HOST/debug/pprof/block，查看导致阻塞同步的堆栈跟踪
    goroutine：$HOST/debug/pprof/goroutine，查看当前所有运行的 goroutines 堆栈跟踪
    heap（Memory Profiling）: $HOST/debug/pprof/heap，查看活动对象的内存分配情况
    mutex（Mutex Profiling）：$HOST/debug/pprof/mutex，查看导致互斥锁的竞争持有者的堆栈跟踪
    threadcreate：$HOST/debug/pprof/threadcreate，查看创建新OS线程的堆栈跟踪
## 4. go tool pprof http://192.168.56.101:6060/debug/pprof/heap //命令行查看内存
## 5. go tool pprof -http 0.0.0.0:8000 http://192.168.56.101:6060/debug/pprof/heap //需要yum install graphviz, web页面查看内存

```
## 如何分析内存泄漏
```
curl "$host/debug/pprof/heap" > orig
# 暂停一段时间
curl "$host/debug/pprof/heap" > now

go tool pprof --base orig now // 哪个内存占用一直在升高，说明哪里有内存泄漏
```


