from __future__ import print_function 
from functools import wraps
def my_decorator(f):
    @wraps(f)
    def wrapper(*args):
        print('calling decorated function')
        return f(*args)
    return wrapper 

@my_decorator 
def func():
    '''doc  example
    '''
    print('calling original function')

func()
print(func.__name__, func.__doc__)


from functools import partial

def f(x, y, z=10):
    print(x, y, z)

partial(f,1)(2)


## python3.x
#from functools import partialmethod
#class Cell:
#    def __init__(self):
#        self._alive = False

#    @property
#    def alive(self):
#        return self._alive

#    def set_state(self, state):
#        self._alive = bool(state)

#    set_alive = partialmethod(set_state, True)
#    set_dead = partialmethod(set_state, False)

#c = Cell()
#print(c.alive)
#c.set_alive()
#print(c.alive)

#reduce
from operator import add 
from functools import reduce
print(reduce(add, range(10)))
