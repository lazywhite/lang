import asyncio

async def hello_world(x):
    print('hello_world x' + str(x))
    await asyncio.sleep(x)


'''
py3.5 之前的做法
loop = asyncio.get_event_loop()
try:
    loop.run_until_complete(hello_world(1))
finally:
    loop.close()
'''
asyncio.run(hello_world(1))
print("done")
