import time
import threading
from queue import PriorityQueue

class MyThread(threading.Thread):
    def __init__(self, priority, name, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.name = name
        self.priority = -priority

def do_this(n):
    print('do this started')
    #started_event.set()
    time.sleep(n)

thread_name_list = [ 'thread_'+str(i) for i in range(1,11) ]
priority_list = range(0,100,10)

#thread_queue = PriorityQueue(maxsize=5) #如果超出maxsize, thread_queue.put()将会阻塞
thread_queue = PriorityQueue(maxsize=15)


for item in zip(priority_list, thread_name_list):
    thread = MyThread(*item, target=do_this, args=(2,),daemon=False)
    thread_queue.put((thread.priority, thread))

while not thread_queue.empty():
    print(thread_queue.qsize())
    thread_item = thread_queue.get()
    thread_item[1].run()
    print(thread_item[0])

