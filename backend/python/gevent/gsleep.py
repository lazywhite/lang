import gevent
from gevent.event import AsyncResult

a = AsyncResult()

def asetter():
    """
    After 3 seconds set the result of a.
    """
    gevent.sleep(3) # will switch to other greenlet
    a.set('Hello!')

def awaiter():
    """
    After 3 seconds the get call will unblock after the setter
    puts a value into the AsyncResult.
    """
    print(a.get())

def task():
    print("not sleeping")

     
gevent.joinall([
    gevent.spawn(asetter),
    gevent.spawn(awaiter),
    gevent.spawn(task),
])
