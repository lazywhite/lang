import time
from functools import wraps

def timethis(func):
    ''' Decorator that reports the execution time
    '''
    @wraps(func) # this decorator preserve metadata of func
    def wrapper(*args, **kwargs):
        start = time.time()
        result = func(*args, **kwargs)
        end = time.time()
        print(func.__name__, end-start)
        return result
    return wrapper

@timethis
def count_down(n:int):
    ''' count down'''
    while n > 0:
        n -= 1

print(count_down.__doc__)
print(count_down.__annotations__)
print('origin call')
count_down.__wrapped__(100)
print('called')
count_down(1000)
