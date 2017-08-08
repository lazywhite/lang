/*
 * Copyright (C) 2017 white <white@localhost>
 *
 * Distributed under terms of the MIT license.
 */

#include <string>
#include <map>
#include <iostream>
using namespace std;

int main(){
    //声明map;
    map<string, int> mmap;
    //第一种插入
    mmap.insert(pair<string, int>("key1", 10));
    mmap.insert(pair<string, int>("key2", 20));
    //第二种插入
    mmap["key3"] = 30;

    //map属性
    cout << mmap.size() << endl;
    cout << mmap.empty() << endl;
    cout << mmap["key3"] << endl;

    //删除元素
    mmap.erase("key2");


    //map遍历
    map<string, int>::iterator it;
    for(it = mmap.begin();it != mmap.end();it++){
        cout << it->first << ":" << it->second << endl;
    }

    return 0;
}
