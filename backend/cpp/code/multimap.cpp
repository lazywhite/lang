/*
 * multimap.cpp
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

#include <map>
#include <string>
#include <iostream>
using namespace std;

typedef multimap<string, int> Mmap;
int main(){
    Mmap mmap;
    mmap.insert(pair<string, int>("bob", 1));
    mmap.insert(pair<string, int>("bob", 2));
    mmap.insert(pair<string, int>("bob", 3));

    mmap.insert(make_pair("bob", 4));

    //返回同key的value个数
    cout << mmap.count("bob") << endl;


    Mmap::iterator it;
    //只返回匹配到的第一个pair的指针
    it = mmap.find("bob");
    cout << it->first << ":" << it->second <<  endl;


    //mmap["bob"];  multimap无法使用下标来访问元素


    //multimap迭代
    Mmap::iterator iter = mmap.lower_bound("bob");
    while(iter != mmap.end()){
        cout << iter->first << ":" << iter->second <<  endl;
        iter++;
    }


    return 0;
}
