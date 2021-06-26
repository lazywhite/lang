import socket
import sys

messages = [b'this is the message', 
        b'it will be sent',
        b'in parts'
        ]

server_address = ('localhost', 10000)

socks = [
        socket.socket(socket.AF_INET, socket.SOCK_STREAM),
        socket.socket(socket.AF_INET, socket.SOCK_STREAM),
        ]

for s in socks:
    s.connect(server_address)

for message in messages:
    for s in socks:
        print('{}: sending {}'.format(s.getsockname(), message))
        s.send(message)

    for s in socks:
        data = s.recv(1024)
        print('{}: received {}'.format(s.getsockname(), data))
        if not data:
            print('closing {]'.format(s.getsockname()))
            s.close()
