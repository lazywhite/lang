# attaching informational metadata to function

def f(x:int, y:int) -> int:
    return x+y
print(f(10,20))
print(f.__annotations__)
