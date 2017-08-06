/*
 * xx.cpp
 * Copyright (C) 2017 white <white@Whites-Mac-Air.local>
 *
 * Distributed under terms of the MIT license.
 */

#include <iostream>
#include <string>
using namespace std;

void printBook(struct Books);

struct Books{
    string title;
    string author;
    int book_id;
};

typedef struct {
    string name;
    int age;
} Author;

//必须放在typedef之后
void printAuthor(Author);

int main(){
    struct Books book1;
    book1.author = "bob";
    book1.title = "Learnign";
    book1.book_id = 100;
    printBook(book1);


    Author author;
    author.name = "bobo";
    author.age = 10;
    printAuthor(author);



    // 结构体指针
    struct Books* book_pt; 
    book_pt = &book1;
    cout << book_pt->author << endl; //通过指针访问结构体member, 必须用"->"

    return 0;
}


void printBook(struct Books book){
    //正常访问member 使用"."
    cout << book.title << endl;
    cout << book.author << endl;
    cout << book.book_id << endl;

}


void printAuthor(Author author){
    //正常访问member 使用"."
    cout << author.name << endl;
    cout << author.age << endl;

}

