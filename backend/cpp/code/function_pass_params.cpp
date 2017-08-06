/*
 * Copyright (C) 2017 white <white@localhost>
 *
 * Distributed under terms of the MIT license.
 */

#include <iostream>
using namespace std;

void swap_by_value(int a, int b){
    int temp;
    temp = a;
    a = b;
    b = temp;
}

void swap_by_ref(int& a, int& b){
    int temp;
    temp = a;
    a = b;
    b = temp;

}
void swap_by_pointer(int* a, int* b){
    int temp;
    temp = *a;
    *a = *b;
    *b = temp;
}

int main(){
    int x = 10, y = 20;
    cout << "before call by value swap x:" << x << " y:" << y<< endl;
    swap_by_value(x, y);
    cout << "after call by value swap x:" << x << " y:" << y<< endl;


    cout << "before call by reference swap x:" << x << " y:" << y<< endl;
    swap_by_ref(x, y);
    cout << "after call by reference swap x:" << x << " y:" << y<< endl;
    

    cout << "before call by pointer swap x:" << x << " y:" << y<< endl;
    swap_by_pointer(&x, &y);
    cout << "after call by pointer swap x:" << x << " y:" << y<< endl;
}



