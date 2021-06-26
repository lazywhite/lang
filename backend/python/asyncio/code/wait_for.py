import asyncio

async def something():
    await asyncio.sleep(2)
    print("done")


async def main():
    try:
        await asyncio.wait_for(something(), timeout=1)
    except asyncio.TimeoutError:
        print("timeout")
    print("main done")


asyncio.run(main())
