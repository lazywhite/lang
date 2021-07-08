#include <stdlib.h>
#include "person.h"


Person *get_person(const char *name, const char *long_name){

    Person *p = malloc(sizeof(Person));
    p->name = name;
    p->long_name = long_name;

    return p;
};
