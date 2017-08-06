/*
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

#include <iostream>
#include <fstream>
using namespace std;

int main(){

    ofstream outfile;
    outfile.open("out.dat" );
    cout << "writing file" << endl;
    outfile << "good" << endl;
    outfile.close();

    ifstream infile;
    infile.open("out.dat");
    char data[100];
    cout << "reading file" << endl;
    while(!infile.eof()){
        infile >> data;
        cout << data << endl;
    }


    infile.close();
    
}

