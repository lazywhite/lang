#include <stdio.h>
#include <math.h>
#include <stdbool.h>

int t_max(){
    return 0;
}

int main(){
    // 多维数组
    int multi_arr[2][5] = {
        {1,2,3,4,5},
        {6,7,8,9,10}
    };
    // 指向整数的指针
    int a = 10, b = 20;
    int *p = &a;
    int *q;
    q = &b;

    // 指向字符串的指针
    char my_str[20] = "hello world";
    char *p_str = my_str;
    char *pc;
    pc = "hello world";
    pc += 6;

    printf("%s\n", pc);

    // 指向数组的指针
    int arr[4] = {0, 1, 2, 3};
    int *p_arr = arr;
    printf("%X\n", *p_arr);
    // 1. 只有数组指针变量相加减才有意义, 其他类型均无意义
    // 2. 指向同一个数组的指针变量才能运算, 否则毫无意义
    p_arr += 2;
    printf("%X\n", *p_arr);
    // 空指针: 对指针变量赋0值, 而不是NULL值
    int *pnull = 0;

    // 指向函数的指针
    int (*pf)() = t_max;
    printf("%X\n", pf);

    // 指向指针的指针
    

    // 结构体
    struct student{
       char * name;
       int age;
       bool gender;
    };
    struct student stu1, stu2;
    stu1.name = "name1";
    stu1.age = 20;
    stu1.gender = true;

    printf("%s-%d-%d\n", stu1.name, stu1.age, stu1.gender);


    
}
