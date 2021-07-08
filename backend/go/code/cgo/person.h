#ifndef PERSON_H
#define PERSON_H

typedef struct Person  {
    const char * name;
    const char * long_name;
} Person ;

Person *get_person(const char * name, const char * long_name);

#endif
