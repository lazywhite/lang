/*
 * vector.cpp
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

#include <vector>
#include <string>
#include <iostream>
using namespace std;


typedef struct {
    string name;
    int age;
} Student;

typedef vector<Student> MyVec;
int main(){
    
    MyVec vec;
    Student s1;
    Student s2;
    s1.name = "bob";
    s1.age = 10;

    s2.name = "alice";
    s2.age = 20;


    vec.push_back(s1);
    vec.push_back(s2);
    vec.pop_back();//空返回值, 删除最后一个元素

    cout << vec.max_size() << endl;
    cout << vec.size() << endl;
    cout << vec.capacity() << endl;

    //获取元素的两种方法
    cout << vec.at(0).name << endl;
    cout << vec[0].name << endl;

    //正向迭代
    MyVec::iterator it;
    it = vec.begin();
    while(it != vec.end()){
        cout << it->name << ":" << it->age << endl;
        it++;
    }


    //反向迭代
    MyVec::reverse_iterator rit;
    rit = vec.rbegin() ;
    while(rit != vec.rend()){
        cout << rit->name << ":" << rit->age << endl;
        rit++;
    } 

    return 0;

}
