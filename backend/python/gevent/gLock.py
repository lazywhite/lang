from gevent import sleep
from gevent.pool import Pool
from gevent.lock import BoundedSemaphore

#sem = BoundedSemaphore()
sem = BoundedSemaphore(2) # 锁池

def worker1(n):
    sem.acquire()
    print('worker %i acquired semaphore' % n)
    sleep(1)
    sem.release()
    print('worker %i released semaphore' % n)


def worker2(n):
    with sem:
        print('worker %i acquired semaphore' % n)
        sleep(1)
    print('worker %i released semaphore' % n)


pool = Pool()
pool.map(worker1, range(0, 2))
pool.map(worker2, range(3, 6))

