from collections import deque
def count_down(n):
    while n > 0:
        print('counting down', n)
        yield n
        n -= 1
    print('blast off')


def count_up(n):
    x = 0
    while x < n:
        print('counting up', x)
        yield x
        x += 1
    print('top reached')

class TaskScheduler:
    def __init__(self):
        self._task_queue = deque()

    def new_task(self, task):
        self._task_queue.append(task)

    def run(self):
        while self._task_queue:
            task = self._task_queue.popleft()
            try:
                next(task)
                self._task_queue.append(task)
            except StopIteration:
                pass

sched = TaskScheduler()
sched.new_task(count_up(4))
sched.new_task(count_up(8))
sched.new_task(count_down(10))
sched.run()
