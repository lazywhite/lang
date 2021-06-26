from typing import Callable, Optional


def addOne(v: int) -> int:
    return v + 1

def f(a: int, b: Callable[[int], int]):
    return b(a)


b = f(10, addOne)
print(b)



def return_error_or_int(v) -> Optional[int]:
    if v == 1:
        return 1
    return None

