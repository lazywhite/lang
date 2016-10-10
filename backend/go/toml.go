package main

import (
	"fmt"
	"github.com/BurntSushi/toml"
	"time"
)

type tomlConfig struct {
	Title   string
	Owner   ownerInfo
	DB      database `toml:"database"`
	Servers map[string]server
	Clients clients
}

type ownerInfo struct {
	Name string
	Org  string `toml:"organization"`
	Bio  string
	DOB  time.Time
}

type database struct {
	Server string
	Ports  []int

	ConnMax int `toml:"connection_max"`
	Enabled bool
}

type server struct {
	IP string
	DC string
}

type clients struct {
	Data  [][]interface{}
	Hosts []string
}

func main() {
	var config tomlConfig

	if _, err := toml.DecodeFile("example.toml", &config); err != nil {
		fmt.Println(err)
		return
	}

	fmt.Printf("Title: %s\n", config.Title)
	fmt.Printf("Owner: %s (%s %s), Born: %s\n",
		config.Owner.Name, config.Owner.Org, config.Owner.Bio, config.Owner.DOB)

	for serverName, server := range config.Servers {
		fmt.Printf("Server: %s (%s, %s)\n", serverName, server.IP, server.DC)
	}

}
