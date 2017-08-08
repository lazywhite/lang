/*
 * list.cpp
 * Copyright (C) 2017 white <white@localhost>
 *
 * Distributed under terms of the MIT license.
 */

#include <algorithm>
#include <list>
#include <string>
#include <iostream>
//#include "list.h"
using namespace std;


typedef list<string> Words;

int main(){
    
    Words w;
    w.push_back("hello");
    w.push_back("world"); 

    cout << w.front() << endl;

    for(string s : w){
        cout << s << endl;
    }

    return 0;
}
