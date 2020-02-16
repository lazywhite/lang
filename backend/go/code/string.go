//
// string.go
// Copyright (C) 2020 white <white@Whites-Mac-Air.local>
//
// Distributed under terms of the MIT license.
//

package main

import "fmt"
import "strings"
import "strconv"

type IPAddr [4]byte

func (ip IPAddr) String() string{
	s := make([]string, len(ip))
	for _, v := range ip{
		s = append(s, strconv.Itoa(int(v)))
	}
	return strings.Join(s, ".")
}

func main() {
	hosts := map[string]IPAddr{
		"loopback":  {127, 0, 0, 1},
		"googleDNS": {8, 8, 8, 8},
	}
	for name, ip := range hosts {
		fmt.Printf("%v: %s\n", name, ip.String())
	}
}
