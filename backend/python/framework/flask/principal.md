## Introduction

Flask-principal provides a very loose framework to tie in providers of two 
types of service, ofen located in different parts of a web application  
1. Authentication providers  
2. User information providers  

authentication provider: oauth  
user information provider: relational database  
framework looseness: signal interface

## Identity
the identity represent the user, and is stored/loaded from various locations
for each request, the identity is the user's avatar to the system, It contains
the access rights that user has

## Needs
A Need is the smallest grain of access control, and represent a specific 
parameter for the situation, for example "has the admin role", "can edit blog"

Need could be any tuple, or probably could be object you like, but a tuple
fits perfectly, the predesigned Need Types(for saving your typing) are either
pairs of (method, value) where method is used to specified common things like "role" "user", and the value is value, An example of such is ('role', 'admin'), which would be a Need for admin role, Or Triples for use-cases such as "the permission to edit a particular instance of an object or row", which might be represented as the triple('article', 'edit', 46), where 46 is the key/ID for that row/object.

Essentially, how and what Needs are is very much down to the user, and is designed very loosely so that any effect can be achived by using custom instances as Needs

Whilst a Need is a permission to access a resource, and Identity should provide 
as set of Needs that it has access to



## Permission

A permission is a set of requirements, any of which should be present for
access to a resource

## IdentityContext
An identityContext is the context of a certain identity against a certain 
Permission , It can be used as a context manager, or a decorator.  
