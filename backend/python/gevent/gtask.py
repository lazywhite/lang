import gevent
import random
import timeit

def task(pid):
    gevent.sleep(random.randint(0,2)* 0.1)
    print('task %s is done' % pid)


def synchronous():
    for i in range(10):
        task(i)

def asynchronous():
        threads = [gevent.spawn(task, i) for i in range(10)]
        gevent.joinall(threads)

print('synchronous:')
print(timeit.timeit('synchronous()', setup="from __main__ import synchronous", number=1))

print('asynchronous:')
print(timeit.timeit('asynchronous()', setup="from __main__ import asynchronous", number=1))
