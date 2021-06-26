import select
import socket
import queue
import sys

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.setblocking(0)

server_address = ('localhost', 10000)

server.bind(server_address)
server.listen(5)

inputs = [ server ]
outputs = []
message_queue = {}

while inputs:
    print('waiting for the next event')
    timeout = 1
    readable, writable, exceptional = select.select(inputs, outputs, inputs, timeout)
    if not any((readable, writable, exceptional)):
        continue
    for s  in readable:
        if s is server:
            connection, client_address = s.accept()
            print('connecte from {}'.format(client_address))
            connection.setblocking(0)
            inputs.append(connection)
            message_queue[connection] = queue.Queue()
        else:
            data = s.recv(1024)
            if data:
                print('received {} from {}'.format(data, s.getpeername()))
                message_queue[s].put(data)
                if s not in outputs:
                    outputs.append(s)
            else:
                print('closing', client_address)
                if s in outputs:
                    outputs.remove(s)
                inputs.remove(s)
                s.close()
                del message_queue[s]


    for s in writable:
        try:
            next_msg = message_queue[s].get_nowait()
        except queue.Empty:
            print(s.getpeername(), 'queue empty')
            outputs.remove(s)
        else:
            print('sending {} to {}'.format(next_msg, s.getpeername()))
            s.send(next_msg)

    for s in exceptional:
        print('exception condition on', s.getpeername())
        inputs.remove(s)
        if s in outputs:
            outputs.remove(s)
        s.close()

        del message_queue[s]




