import multiprocessing
import time

'''
Lock 可以被多线程，进程共享，均可以释放
RLock只能被acquire的线程，进程释放, 否则报AssertionError
'''

def f1(l):
    p_name = multiprocessing.current_process().name
    l.acquire()
    print('hello from %s' % p_name)

def f2(l):
    p_name = multiprocessing.current_process().name

    time.sleep(1)
    print('release by %s' % p_name)
    l.release()


if __name__ == '__main__':
    lock = multiprocessing.RLock()
    multiprocessing.Process(target=f1, args=(lock,)).start()
    multiprocessing.Process(target=f2, args=(lock,)).start()
