import gevent

from gevent.queue import Queue, Empty, Full

tasks = Queue(maxsize=3)

def worker(n):
    try:
        while True:
            task = tasks.get(timeout=1)
            print("worker %s got job %s" %(n, task))
    except Empty:
        print("Break time")


def boss():
    try:
        for i in xrange(1, 10):
            print('making job %s' % i)
            tasks.put_nowait(i)
    except Full:
        '''non block put, raise Full exception
            skipped left 
        '''
        gevent.sleep(0)
    print("assign all work in integration 1")

    try:
        for i in xrange(10, 20):
            print('making job %s' % i)
            tasks.put_nowait(i)
    except Full:
        gevent.sleep(0)
    print("assign all work in integration 2")

gevent.joinall([
    gevent.spawn(boss),
    gevent.spawn(worker, 'bob'),
    gevent.spawn(worker, 'steve'),
    gevent.spawn(worker, 'alice'),

    ])
