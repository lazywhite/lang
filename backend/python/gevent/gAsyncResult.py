import gevent
from gevent.event import AsyncResult


a = AsyncResult()

def setter():
    gevent.sleep(3)
    result = "hello"
    a.set(result)
    print("result is %s" % result)

def waiter():
    print("get value: %s" % a.get())

def nonblock():
    print('non blocking')

gevent.joinall([
    gevent.spawn(waiter),
    gevent.spawn(waiter),
    gevent.spawn(setter),
    gevent.spawn(waiter),
    gevent.spawn(waiter),
    gevent.spawn(nonblock),
    ])
