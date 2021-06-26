from functools import  lru_cache
import sys

'''
太大的参数n必须要设置递归最大层数

需要python>=3.5
'''
print(sys.getrecursionlimit())
sys.setrecursionlimit(1000000)

@lru_cache(maxsize=1280000000)
def f(n):
    if n <= 2:
        return n - 1

    return f(n-1) + f(n-2)


print(f(20))
