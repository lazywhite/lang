import asyncio 
import time 

'''
py3.7 后可使用create_task, 之前需要使用ensure_future(不推荐)
'''
async def dosomething(num): 
    print('start{}'.format(num)) 
    await asyncio.sleep(num) 
    print('sleep{}'.format(num)) 

async def main(): 
    task1 = asyncio.create_task(dosomething(1)) 
    task2 = asyncio.create_task(dosomething(2)) 
    task3 = asyncio.create_task(dosomething(3)) 
    '''
    task1 = asyncio.ensure_future(dosomething(1)) 
    task2 = asyncio.ensure_future(dosomething(2)) 
    task3 = asyncio.ensure_future(dosomething(3)) 
    '''
    await task1 
    await task2 
    await task3 

if __name__ == '__main__': 
    time_start = time.time() 
    asyncio.run(main()) 
    print(time.time() - time_start) 
