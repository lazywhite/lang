import socket
import sys
import os

server_address = '/tmp/uds_socket.sock'

try:
    os.unlink(server_address)
except OSError:
    if os.path.exists(server_address):
        raise

sock = socket.socket(socket.AF_UNIX, socket.SOCK_STREAM)

sock.bind(server_address)
sock.listen(1)

conn, client = sock.accept()
try:
    print('connection from: ', client)
    data = conn.recv(1024)
    print(data)
    conn.send(bytes(data.encode('utf-8')))
finally:
    conn.close()

