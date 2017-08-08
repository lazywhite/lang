/*
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

#include <unordered_map>
#include <string>
#include <iostream>
using namespace std;


/* <ext/hash_map> 已废弃 */
typedef unordered_map<string, int> HashMap;

int main(){
    
    HashMap map;
    map["key1"] = 100;
    map["key2"] = 200;
    map["key3"] = 300;

    HashMap::iterator it ;
    it = map.find("key1");

    cout << it->first << ":" << it->second << endl;
    cout << map["key3"] << endl;

    return 0;
}
