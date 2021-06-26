import asyncio
import time



async def dosomething(num):
    print('第 {} 任務，第一步'.format(num))
    await asyncio.sleep(1)
    print('第 {} 任務，第二步'.format(num))
    return '第 {} 任務完成'.format(num)

async def raise_error(num):
    raise ValueError

async def main():
    tasks = [dosomething(i) for i in range(5)]
    tasks1 = [raise_error(i) for i in range(5)]

    # 此处必须有await, 不然会直接执行下面
    results = await asyncio.gather(*tasks, *tasks1, return_exceptions=True)
    print(results)


if __name__ == "__main__":

    start = time.time()
    asyncio.run(main())
    print('TIME: ', time.time() - start)
