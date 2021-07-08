#include <stdio.h>
#include "person.h"

int main(int argc, char** argv)
{
    Person* p;
    p = get_person("tim", "tim hughes");
    printf("Hello C world: My name is %s, %s.\n", p->name, p->long_name);
    return 0;
}
