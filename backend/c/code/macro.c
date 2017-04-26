#include <stdio.h>
#undef  FILE_SIZE
#define FILE_SIZE 42
#ifndef MESSAGE
   #define MESSAGE "You wish!"
#endif
#ifdef DEBUG
   /* Your debugging statements here */
#endif



int main() {

    printf("File :%s\n", __FILE__ );
    printf("Date :%s\n", __DATE__ );
    printf("Time :%s\n", __TIME__ );
    printf("Line :%d\n", __LINE__ );
    printf("ANSI :%d\n", __STDC__ );
    return 0;
}
