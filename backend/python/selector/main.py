'''
high level and efficient I/O multiplexing, built upon select module
default selector is the best implementation 
    epoll|kqueue > poll > select
'''
import selectors 
import socket 

sel = selectors.DefaultSelector()

def accept(sock, mask):
    conn, addr = sock.accept()
    print('accepted', conn, 'from', addr)
    conn.setblocking(False)
    sel.register(conn, selectors.EVENT_READ, read)

def read(conn, mask):
    data = conn.recv(1000)
    if data:
        print('echoing', repr(data), 'to', conn)
        print('mask:', mask)
        conn.send(data)

    else:
        print('closing', conn)
        sel.unregister(conn)
        conn.close()

sock = socket.socket()
sock.bind(('127.0.0.1', 8000))
sock.listen(100)
sock.setblocking(False)
sel.register(sock, selectors.EVENT_READ, accept)


while True:
    events = sel.select()
    for key, mask in events:
        callback = key.data
        callback(key.fileobj, mask)
