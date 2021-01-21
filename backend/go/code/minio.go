package main

import (
	"bytes"
	"context"
	"fmt"
	"gopkg.in/yaml.v3"
	"io"
	"log"

	"github.com/minio/minio-go/v7"
	"github.com/minio/minio-go/v7/pkg/credentials"
	"os"

)

func main() {
	endpoint := os.Getenv("MINIO_HOST")
	accessKeyID := os.Getenv("MINIO_AK")
	secretAccessKey := os.Getenv("MINIO_SK")
	useSSL := false

	// Initialize minio client object.
	minioClient, err := minio.New(endpoint, &minio.Options{
		Creds:  credentials.NewStaticV4(accessKeyID, secretAccessKey, ""),
		Secure: useSSL,
	})
	if err != nil {
		log.Fatalln(err)
	}
	/*
	for obj := range minioClient.ListObjects(context.TODO(), "workflow", minio.ListObjectsOptions{Recursive: true}){
		fmt.Println(obj.Key)
	}

	 */

	//log.Printf("%#v\n", minioClient) // minioClient is now set up
	object, err := minioClient.GetObject(context.TODO(), "buck01", "path/to/demo.yaml", minio.GetObjectOptions{})
	if err != nil {
		fmt.Println(err)
		return
	}

	defer object.Close()

	b := new(bytes.Buffer)
	io.Copy(b, object)

	fmt.Println(b.String())
}

