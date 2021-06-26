from contextlib import contextmanager 

@contextmanager 
def f(n):
    print('before') # phrase before 'yield' is __enter__
    yield 
    print('after') # phrase after 'yield' is __exit__

with f(5) as f:
    print('magic')
