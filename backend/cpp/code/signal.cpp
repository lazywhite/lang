/*
 * signal.cpp
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

#include <iostream>
#include <csignal>
#include <unistd.h>
using namespace std;

void signalHandler(int signum){
    cout << "Interrupt signal " << signum  << endl;
    exit(signum);
}

int main(){
   signal(SIGINT, signalHandler); //注册想要捕获的信号, 并绑定处理函数
   int i = 0;
   while (i < 10){
        cout << "Going to sleep ..." << endl;
        sleep(1);
        i++;

        if(i == 3 ){
            raise(SIGINT);  // 生成信号
        }
        
   }
   return 0;

}



