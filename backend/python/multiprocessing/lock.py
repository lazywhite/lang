import multiprocessing

'''
Lock 非递归锁
    A non-recursive lock object: a close analog of threading.Lock. Once a process or thread has acquired a lock, subsequent attempts to acquire it from any process or thread will block until it is released; any process or thread may release it. The concepts and behaviors of threading.Lock as it applies to threads are replicated here in multiprocessing.Lock as it applies to either processes or threads, except as noted.

    Note that Lock is actually a factory function which returns an instance of multiprocessing.synchronize.Lock initialized with a default context.


RLock 递归锁
    A recursive lock object: a close analog of threading.RLock. A recursive lock must be released by the process or thread that acquired it. Once a process or thread has acquired a recursive lock, the same process or thread may acquire it again without blocking; that process or thread must release it once for each time it has been acquired.
    Note that RLock is actually a factory function which returns an instance of multiprocessing.synchronize.RLock initialized with a default context.
'''


def f(l, i):
    '''一定要和try，finally使用, 防止锁不释放
    '''
    p_name = multiprocessing.current_process().name
    l.acquire()
    try:
        print('hello from %s' % p_name, i)
    finally:
        l.release()


if __name__ == '__main__':
    print(multiprocessing.get_all_start_methods())
    print(multiprocessing.get_start_method())
    '''
    multiprocessing.set_start_method('fork')
    '''
    lock = multiprocessing.Lock()
    for i in range(10):
        multiprocessing.Process(target=f, args=(lock, i)).start()
