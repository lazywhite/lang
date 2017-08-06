/*
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

#include <iostream>
#include <ctime>

using namespace std;

int main(){

    time_t now = time(0);
    cout << now << endl;
    char* dt = ctime(&now);
    cout << dt << endl;


    tm *ltm = localtime(&now);
    cout << 1900 + ltm->tm_year<< endl;
    cout << 1 + ltm->tm_mon<< endl;
    cout << ltm->tm_mday<< endl;
    cout << ltm->tm_hour<< endl;
    cout << ltm->tm_min<< endl;
    cout << ltm->tm_sec<< endl;
    
    return 0;


}

