import threading
from random import randint


'''
每个线程调用同一个threading.local(), 自动获取对应线程的local对象

store为一个instance, 可以赋值新属性
'''
store = threading.local()




def task(number):
    store.number = number
    print(10 * store.number)


for i in range(10):
    t = threading.Thread(target=task, args=(i, ))
    t.start()
    t.join()

