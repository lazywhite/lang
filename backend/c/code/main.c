#include <stdio.h>
#include <limits.h>
#include <math.h>

#define PI 3.14
#define NEWLINE "\n"
#define STR "hello"

int main(){
    /*
     * keyword: auto register extern static
     *          if else  switch case for while do goto
     *          break continue
     *          short int long double float void signed unsigned 
     *          char byte
     *          sizeof typedef return 
     *          volatile default const 
     *          union struct
     *
     *
     */
    // Enum
    enum weekDay {
        SUN = 0,
        MON = 1,
        TUE,
        WED,
        THU,
        FRI,
        SAT
    };

    enum weekDay day = TUE;

    //array
    char greeting[] = "hello world"; //size could be omitted
    double balance[] = {1000.0, 2.0, 3.4, 7.0, 50.0};

    // Structure
    struct rectangle{
        int width;
        int height;
    };

    struct rectangle my_rect;
    my_rect.width = 100;
    my_rect.height = 10;
    printf("Size of my_rect: %d\n", my_rect.width * my_rect.height);

    printf("index of TUE is: %d\n", TUE);

    unsigned int a = 10;
    // Pointer 
    unsigned int *p;
    p = &a;
    const int width = 100;
    printf("value of area: %.2f\n", pow(width, 2) * PI);
    printf("value of pointer p: %p\n", p);
    printf("value of const string STR: %s\n", STR);
    printf("value of string greeting: %s\n", greeting);


    int s = sizeof(int);
    printf("Size of int: %d\n", s);
        
    return 0;
}
