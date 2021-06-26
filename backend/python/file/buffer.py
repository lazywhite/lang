import os.path


def read_into_buffer(filename):
    buf = bytearray(os.path.getsize(filename))
    with open(filename, 'rb') as f:
        f.readinto(buf)
    return buf

buf = read_into_buffer('a.txt')
print(buf.decode('utf-8'))
print(len(buf))
print(buf[0:3])
