package main

import (
	"context"
	"fmt"
	"time"

	"k8s.io/api/core/v1"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/util/wait"
	"k8s.io/client-go/informers"
	"k8s.io/client-go/kubernetes/fake"
	"k8s.io/client-go/tools/cache"
)

// TestFakeClient demonstrates how to use a fake client with SharedInformerFactory in tests.
func main() {
	ctx, cancel := context.WithCancel(context.Background())
	defer cancel()

	// Create the fake client.
	client := fake.NewSimpleClientset()


	// We will create an informer that writes added pods to a channel.
	pods := make(chan *v1.Pod, 1)
	informer := informers.NewSharedInformerFactory(client, 0)
	podInformer := informer.Core().V1().Pods().Informer()
	podInformer.AddEventHandler(&cache.ResourceEventHandlerFuncs{
		AddFunc: func(obj interface{}) {
			pod := obj.(*v1.Pod)
			fmt.Printf("pod added: %s/%s\n", pod.Namespace, pod.Name)
			pods <- pod
		},
	})

	// Make sure informers are running.
	informer.Start(ctx.Done())

	// This is not required in tests, but it serves as a proof-of-concept by
	// ensuring that the informer goroutine have warmed up and called List before
	// we send any events to it.
	cache.WaitForCacheSync(ctx.Done(), podInformer.HasSynced)

	// Inject an event into the fake client.
	p := &v1.Pod{ObjectMeta: metav1.ObjectMeta{Name: "my-pod"}}
	_, err := client.CoreV1().Pods("test-ns").Create(p)
	if err != nil {
		fmt.Printf("error injecting pod add: %v\n", err)
	}

	select {
	case pod := <-pods:
		fmt.Printf("Got pod from channel: %s/%s\n", pod.Namespace, pod.Name)
	case <-time.After(wait.ForeverTestTimeout):
		fmt.Println("Informer did not get the added pod")
	}
}
