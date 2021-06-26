import socket
import struct
import time
message = 'very important data'

multicast_group = ('224.10.28.1', 10000)
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

sock.settimeout(0.2)

ttl = struct.pack('b', 1)
sock.setsockopt(socket.IPPROTO_IP, socket.IP_MULTICAST_TTL, ttl)

try:
    print('sending message...')
    sent = sock.sendto(bytes(message.encode('utf-8')), multicast_group)

    while True:
        print('waiting to receive')
        try:
            data, server = sock.recvfrom(16)
        except socket.timeout:
            print('timeout, no more response')
        else:
            print('received {} from {}'.format(data, server))
        time.sleep(5)

finally:
    print('closing socket')
    sock.close()
