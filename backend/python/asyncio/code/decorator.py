import asyncio 
import time 

'''
@asyncio.coroutine py3.8之后已废弃, 推荐使用async def
'''
@asyncio.coroutine
def dosomething(num): 
    print('start{}'.format(num)) 
    yield from asyncio.sleep(num) 
    print('sleep{}'.format(num)) 

@asyncio.coroutine
def main(): 
    task1 = asyncio.create_task(dosomething(1)) 
    task2 = asyncio.create_task(dosomething(2)) 
    task3 = asyncio.create_task(dosomething(3)) 
    '''
    task1 = asyncio.ensure_future(dosomething(1)) 
    task2 = asyncio.ensure_future(dosomething(2)) 
    task3 = asyncio.ensure_future(dosomething(3)) 
    '''
    yield from task1
    yield from task2
    yield from task3

if __name__ == '__main__': 
    time_start = time.time() 
    asyncio.run(main()) 
    print(time.time() - time_start) 
