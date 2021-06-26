import gevent

from gevent.queue import Queue

tasks = Queue()

def worker(n):
    while not tasks.empty():
        task = tasks.get_nowait()
        print("worker %s get task %s" %(n, task))
        gevent.sleep(0)
    print('Break time!')

def boss():
    for i in range(1,25):
        print('boss putting job %d' % i)
        tasks.put(i)

gevent.joinall([
    gevent.spawn(boss),
    gevent.spawn(worker, 'steve'),
    gevent.spawn(worker, 'bob'),
    gevent.spawn(worker, 'alice'),
    ])
