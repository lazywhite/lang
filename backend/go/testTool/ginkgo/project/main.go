package main

import (
    "demo/app"
)

func main(){

    app.Greet("bob")
    app.Greet(app.FullName("donald", "trump"))

}
