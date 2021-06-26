import socket


# 只要dns能解析, 便能返回ip
print(socket.gethostbyname("10.0.0.2"))
print(socket.gethostbyname("localhost"))
print(socket.gethostbyname("www.baidu.com"))
