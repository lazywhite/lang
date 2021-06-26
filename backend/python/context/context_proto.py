from socket import socket, AF_INET, SOCK_STREAM
from functools import partial

class LazyConnection:
    def __init__(self, address, family=AF_INET, type=SOCK_STREAM):
        self.address = address
        self.family = family
        self.type = type
        self.sock = None

    def __enter__(self):
        print('entering')
        if self.sock is not None:
            raise RuntimeError('Already connected')
        self.sock = socket(self.family, self.type)
        self.sock.connect(self.address)
        return self.sock

    def __exit__(self, a, b, c):
        self.sock.close()
        self.sock = None
        print('leaving')

conn = LazyConnection(('www.python.org', 80))
with conn as s: #__enter__ invoked at this line
    s.send(b'GET /index.html HTTP/1.0\r\n')
    s.send(b'HOST: www.python.org\r\n')
    s.send(b'\r\n')
    resp = b''.join(iter(partial(s.recv, 8192), b''))
    print(resp)
