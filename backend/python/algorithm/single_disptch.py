# call different function by the type of an arguments
# only in Python 3.x
from functools import singledispatch

@singledispatch 
def fun(arg, verbose=False):
    if verbose:
        print('let me say')
    print(arg)
    

@fun.register(int)
def _(arg, verbose=False):
    if verbose:
        print('strength in numbers')
    print(arg)
    

@fun.register(list)
def _(arg, verbose=False):
    if verbose:
        print('enumerate this')
    for i, j in enumerate(arg):
        print(i, j)

fun(100, True)
fun([1,2,34], True)

