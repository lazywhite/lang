//
// main_test.go
// Copyright (C) 2020 white <white@bogon>
//
// Distributed under terms of the MIT license.
//

package main

import "testing"

func Test_T(t *testing.T){
    var testVal = []struct{
        in int
        expected bool
    }{
        {1, false},
        {2, true},
        {3, true},
        {4, false},
    }

    for _, item := range testVal {
        calculate := T(item.in)
        if calculate != item.expected {
            t.Errorf("in %d, expected %v, result %v", item.in, item.expected, calculate)
        }

    }
}
