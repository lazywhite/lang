/*
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

#include <iostream>
using namespace std;

//函数重载
void func(string str){
    cout << str  << "hehe" << endl;
}
void func(int  num){
    cout << num  << " 100" << endl;
}

class Shape {
    public:
        string name;
    string title; //默认private
//    protected:
//        int age;
};

class Box: public Shape{
    public:
        double width;
        double height;
        double getArea(void ){
            return height * width;
        }
        double getWidth(void); //先声明, 后实现
        void setName(string name){
            this->name = name;
        }
//        void setAge(int age){
//            this->age = age;
//        }
        static void greet(){
            cout << "hello" << endl;   
        };

        Box(double width, double height){
            this->width = width;
            this->height = height;
        }
        ~Box(void){
            cout <<  "Box destroyed" << endl;
        }
};


double Box::getWidth(void){
    return width;
}

int main(){
    Box b1(10.0, 20.0);
//    b1.setAge(10);

    cout<< b1.getArea()<<endl;;
    cout<< b1.getWidth()<<endl;;
    
    Box::greet(); //静态函数调用

    func(10);
    return 0;

}

