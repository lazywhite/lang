/*
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

#include <iostream>
#include <vector>
#include <cstdlib>
#include <string>
#include <stdexcept>

using namespace std;

//函数模板
template <typename T> inline T const& Max(T const& a, T const& b){
    return a> b?a:b;
}


//类模板
template <class T> 
    class Stack{
        private:
            vector<T> elems;
        public:
            void push(T const&);
            void pop();
            T top() ;
            bool empty() {
                return elems.empty();
            }
    };

template <class T>
void Stack<T>::push(T const& elem){
    elems.push_back(elem);
}

template <class T>
void Stack<T>::pop(){
    if(elems.empty()){
        throw out_of_range("empty stack");
    }
    elems.pop_back();
}

template <class T>
T Stack<T>::top() {
    if(elems.empty()){
        throw out_of_range("empty stack");
    }
    elems.back();
}
int main(){
    int i=10, j=20;
    cout << "max of int: " << Max(i, j) << endl;
    float a=10.0, b= 5.3;
    cout << "max of float " << Max(a, b) << endl;

    try{
        Stack<int> intStack;
        Stack<string> strStack;
        intStack.push(7);
        cout << intStack.top() << endl;

        strStack.push("hello");
        strStack.pop();
        strStack.pop();

    }catch(exception const& ex){
        cerr << "Exception: " << ex.what() << endl;
        return -1;
    }
    return 0;
}


