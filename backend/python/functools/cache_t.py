'''
需要python版本3.9.x以上
'''
from functools import cache


@cache
def fib(n):
    if n <= 2:
        return n
    else:
        return fib(n-1) + fib(n-2)


print(fib(20))
