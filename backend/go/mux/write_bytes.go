//
// write_bytes.go
// Copyright (C) 2020 white <white@localhost>
//
// Distributed under terms of the MIT license.
//

package main

import (
    "fmt"
)
func main(){
    
}


//if your image is stored in a []byte, you can write that directly to the http.ResponseWriter

func GetImage(w http.ResponseWriter, r *http.Request) {
    image, err := getImage() // getImage example returns ([]byte, error)
    if err != {
        http.Error(w, err.Error(), http.StatusInternalServerError)
        return
    }

    w.Write(image)
}
