/*
 * deque.cpp
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

#include <deque>
#include <string>
#include <iostream>
//#include "deque.h"
using namespace std;

typedef deque<int> Myqueue;
int main(){
    
    Myqueue  m;
    m.push_back(10);
    m.push_back(12);
    m.push_back(10);
    m.push_back(10);
    m.push_front(3);
    m.push_front(2);
    m.push_front(1);

    m.pop_back();
    m.pop_front();
    
    cout << "size: " << m.size() << endl;
    cout << "get by index: " << m.at(0) << endl;
    cout << "get by index: " << m[1] << endl;
    
    Myqueue::iterator it;
    it = m.begin();
    while(it!=m.end()){
        cout << "element: " << *it << endl;
        it++;
    }


    return 0;
}
