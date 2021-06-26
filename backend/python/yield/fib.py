def f():
    a, b = 0,1
    while True:
        yield b
        a, b = b, a+b


def a(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    return a(n-1)+a(n-2)


def fib(n):
    a, b = 0, 1
    while a < n:
        print(b, end=' ')
        a, b = b, a+b

fib(10)
