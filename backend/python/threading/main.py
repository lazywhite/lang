import time
import threading
from queue import PriorityQueue

def do_this(n):
    print('do this started')
    print(threading.current_thread()) # 获取当前线程
    time.sleep(n)

    
thread1 = threading.Thread(target=do_this,args=(10,))
thread1.daemon = True

thread2 = threading.Thread(target=do_this,args=(1,))
thread2.daemon = True

thread1.start()
thread2.start()


print(threading.active_count())

time.sleep(5)
print(thread1.is_alive())
print(thread2.is_alive())

print(threading.enumerate()) # 获取当前所有alive的thread list
print(threading.active_count())

thread1.join() # wait until this thread end , will not execute following phases
print("main thread exit")
