from __future__ import print_function
from multiprocessing import Process
import time 
import atexit
import os


running_process = []
def f(name):
    print(os.getpid())
    print(os.getppid())
    while True:
        print("hello " + name)
        time.sleep(10)

def terminate():
    for p in running_process:
        p.terminate()

if __name__ == '__main__':
    #atexit.register(terminate) # 确保主进程退出时, 其他子进程被关闭
    p = Process(target=f, args=('outer',))
    running_process.append(p)
    p.daemon = True  # 子进程的ppid为1,  False时ppid为主进程pid
    p.start()
    p.join()
