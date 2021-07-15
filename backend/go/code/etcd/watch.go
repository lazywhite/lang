package main

import (
	"context"
	"flag"
	"fmt"
	"time"

	clientv3 "go.etcd.io/etcd/client/v3"
)

func main() {
	etcdHost := flag.String("etcdHost", "127.0.0.1:12379", "etcd host")
	etcdWatchKey := flag.String("etcdWatchKey", "/foo", "etcd key to watch")

	flag.Parse()

	fmt.Println("connecting to etcd - " + *etcdHost)

	etcd, err := clientv3.New(clientv3.Config{
		Endpoints:   []string{"http://" + *etcdHost},
		DialTimeout: 5 * time.Second,
	})
	if err != nil {
		panic(err)
	}

	fmt.Println("connected to etcd - " + *etcdHost)

	defer etcd.Close()

	watchChan := etcd.Watch(context.Background(), *etcdWatchKey, clientv3.WithPrefix())
	fmt.Println("set WATCH on " + *etcdWatchKey)

	go func() {
		fmt.Println("started goroutine for PUT...")
		for {
			etcd.Put(context.Background(), *etcdWatchKey, time.Now().String())
			fmt.Println("populated " + *etcdWatchKey + " with a value..")
			time.Sleep(5 * time.Second)
		}

	}()

	for watchResp := range watchChan {
		for _, event := range watchResp.Events {
			fmt.Printf("Event received! %s executed on %q with value %q\n", event.Type, event.Kv.Key, event.Kv.Value)
		}
	}
}
