import time
import gevent
from gevent import select

start = time.time()
tic = lambda : 'at %1.1f seconds' % (time.time() - start)

def gr1():
    print('start polling: %s' % tic())
    select.select([], [], [], 2)
    print('end polling: %s' % tic())


def gr2():
    print('start polling: %s' % tic())
    select.select([], [], [], 2)
    print('end polling: %s' % tic())

def gr3():
    print('lets do sth while greenlets polling, %s' % tic())
    gevent.sleep(1)

gevent.joinall([
    gevent.spawn(gr1),
    gevent.spawn(gr2),
    gevent.spawn(gr3),
    ])
