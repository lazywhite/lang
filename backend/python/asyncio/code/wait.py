import asyncio
import time

'''
coroutine asyncio.wait(aws, *, loop=None, timeout=None, return_when=ALL_COMPLETED)
并发地运行 aws 可迭代对象中的 可等待对象 并进入阻塞状态直到满足 return_when 所指定的条件。
aws 可迭代对象必须不为空。

return_when
    ALL_COMPLETED (default)
    FIRST_COMPLETED
    FIRST_EXCEPTION

返回两个 Task/Future 集合: (done, pending)。

用法:
done, pending = await asyncio.wait(aws)
'''

now = lambda: time.time()

async def dosomething(num):
    print('第 {} 任務，第一步'.format(num))
    await asyncio.sleep(num)
    print('第 {} 任務，第二步'.format(num))

async def main():
    tasks = [dosomething(i) for i in range(5)]
    done, pending = await asyncio.wait(tasks, timeout=2)
    print(f"done: {done}, pending: {pending}")

if __name__ == "__main__":
    start = now()
    asyncio.run(main())
    print('TIME: ', now() - start)
