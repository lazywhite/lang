/*
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

#include <iostream>
using namespace std;

int* func(){
    static int a  = 10;
    return &a;
}


int main(){
    void* p;
    p = func(); //可以将int* 赋值给p, 但是只有地址, 没有长度, 无法取值(*p)
//    cout << *p << endl; //任何情况下都不能对void* 的指针取值
    
    int* q;
    q = (int* )p; //可以将void*的值赋值给其他类型指针, 但要类型转换
    cout << *q << endl; 

    //p++; 无法对void* 指针进行指针运算
    //void a;  //无法将void代表一个真实的变量, 语法错误


}


