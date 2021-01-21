package main

import (
	"fmt"
	"k8s.io/apimachinery/pkg/api/equality"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/apis/meta/v1/unstructured"
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/apimachinery/pkg/runtime/schema"
	"k8s.io/apimachinery/pkg/types"
	"k8s.io/client-go/dynamic/fake"
)

const (
	testGroup      = "testgroup"
	testVersion    = "testversion"
	testResource   = "testkinds"
	testNamespace  = "testns"
	testName       = "testname"
	testKind       = "TestKind"
	testAPIVersion = "testgroup/testversion"
)

func newUnstructured(apiVersion, kind, namespace, name string) *unstructured.Unstructured {
	return &unstructured.Unstructured{
		Object: map[string]interface{}{
			"apiVersion": apiVersion,
			"kind":       kind,
			"metadata": map[string]interface{}{
				"namespace": namespace,
				"name":      name,
			},
		},
	}
}

func newUnstructuredWithSpec(spec map[string]interface{}) *unstructured.Unstructured {
	u := newUnstructured(testAPIVersion, testKind, testNamespace, testName)
	u.Object["spec"] = spec
	return u
}

func main(){
	TestGet()
	TestPatch()

}

func TestGet() {
	scheme := runtime.NewScheme()

	client := fake.NewSimpleDynamicClient(scheme, newUnstructured("group/version", "TheKind", "ns-foo", "name-foo"))
	get, err := client.Resource(schema.GroupVersionResource{Group: "group", Version: "version", Resource: "thekinds"}).Namespace("ns-foo").Get("name-foo", metav1.GetOptions{})
	if err != nil {
		panic(err)
	}

	expected := &unstructured.Unstructured{
		Object: map[string]interface{}{
			"apiVersion": "group/version",
			"kind":       "TheKind",
			"metadata": map[string]interface{}{
				"name":      "name-foo",
				"namespace": "ns-foo",
			},
		},
	}
	if !equality.Semantic.DeepEqual(get, expected) {
		fmt.Println(expected)
		fmt.Println(get)
		panic("not equal")
	}
}


func  TestPatch() {
	//patchType :=  types.StrategicMergePatchType
	patchType :=  types.MergePatchType
	patchBytes := []byte(`{"spec":{"foo":"baz"}}`)

	object :=  newUnstructuredWithSpec(map[string]interface{}{"foo": "bar"})
	client := fake.NewSimpleDynamicClient(runtime.NewScheme(), object)

	resourceInterface := client.Resource(schema.GroupVersionResource{Group: testGroup, Version: testVersion, Resource: testResource}).Namespace(testNamespace)

	got, recErr := resourceInterface.Patch(testName, patchType, patchBytes, metav1.PatchOptions{})

	fmt.Println(got)
	fmt.Println(recErr)

}
