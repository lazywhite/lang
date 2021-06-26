from timeit import timeit
from random import randint
import time


def task():
    time.sleep(randint(1, 3))


# number: 执行次数
# setup: 导入执行对象
# stmt: 执行对象
cost_time = timeit(stmt="task()", setup="from __main__ import task", number=3)
print(cost_time)
