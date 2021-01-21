package main

import (
    v1 "k8s.io/apimachinery/pkg/apis/meta/v1"
    "k8s.io/apimachinery/pkg/runtime/schema"
    "k8s.io/apimachinery/pkg/types"
    "k8s.io/client-go/dynamic"
    "k8s.io/client-go/kubernetes"
    "k8s.io/client-go/tools/clientcmd"
    "log"
)

var clientset *kubernetes.Clientset
var dynamicClient dynamic.Interface

func init() {
    kubeconfig := "/root/.kube/config"
    config, err := clientcmd.BuildConfigFromFlags("", kubeconfig)
    if err != nil {
        log.Fatal(err)
    }

    // create the clientset
    clientset, err = kubernetes.NewForConfig(config)
    if err != nil {
        panic(err.Error())
    }

    dynamicClient, err = dynamic.NewForConfig(config)
}

func main() {
    deploymentsClient := clientset.AppsV1().Deployments("default")

    patch := []byte(`{"spec":{"template":{"spec":{"containers":[{"name":"redis","image":"nginx:1.14-alpine"}]}}}}`)
    _, err := deploymentsClient.Patch("redis-dep", types.StrategicMergePatchType, patch)
    if err != nil {
        panic(err)
    }


    gvr := schema.GroupVersionResource{
        Group:    "apps.mwops.alibaba-inc.com",
        Version:  "v1alpha1",
        Resource: "appsets",
    }
    patch = []byte(`{"spec":{"appSetDep":"test"}}`)
    _, err = dynamicClient.Resource(gvr).Namespace("ark-system").Patch("redis-0", types.MergePatchType, patch, v1.PatchOptions{})
    if err != nil {
        panic(err)
    }
}
