import atexit

def f(a,b,c):
    print(a,b,c)


atexit.register(f, *(1,2,3))
