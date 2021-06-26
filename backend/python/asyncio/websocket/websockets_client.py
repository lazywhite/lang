#!/usr/bin/env python

import asyncio
import websockets

async def hello():
    websocket = await websockets.connect('ws://localhost:8765/')
    name = input("What's your name? ")
    await websocket.send(name)
    print("> {}".format(name))
    greeting = await websocket.recv()
    print("< {}".format(greeting))

asyncio.run(hello())