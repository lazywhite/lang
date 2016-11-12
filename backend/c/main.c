#include <stdio.h>
#include <limits.h>
#include <math.h>

#define PI 3.14
#define NEWLINE "\n"

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
    printf("value of pointer p: %d\n", p);
    return 0;
}
