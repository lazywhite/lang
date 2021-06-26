import socket
import struct

multicast_group = '224.10.28.1'
server_address = ('', 10000)

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sock.bind(server_address)

group = socket.inet_aton(multicast_group)
mreq = struct.pack('4sl', group, socket.INADDR_ANY)
sock.setsockopt(socket.IPPROTO_IP, socket.IP_ADD_MEMBERSHIP, mreq)

while True:
    print('waiting to receive message')
    data, address = sock.recvfrom(1024)
    print('received {} from {}'.format(data, address))
    print('sending ack to {}'.format(address))
    sock.sendto(b'ack', address)
