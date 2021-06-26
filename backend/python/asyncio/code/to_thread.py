import asyncio
import time

'''
在不同的线程中异步运行函数, 主要用于会阻塞event-loop的IO密集型函数
'''
def blocking_io():
    print(f"start blocking_io at {time.strftime('%X')}")
    # Note that time.sleep() can be replaced with any blocking
    # IO-bound operation, such as file operations.
    time.sleep(100)
    print(f"blocking_io complete at {time.strftime('%X')}")

async def main():
    print(f"started main at {time.strftime('%X')}")

    await asyncio.gather(
        asyncio.to_thread(blocking_io),
        asyncio.to_thread(blocking_io),
        asyncio.sleep(10))

    print(f"finished main at {time.strftime('%X')}")


asyncio.run(main())
