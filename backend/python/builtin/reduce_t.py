from functools import reduce

a = range(10)

def f(a, b):
    return a+b

print(reduce(f, a))
