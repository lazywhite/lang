import sys

print(sys.getdefaultencoding())
sys.stdout.write('fefe')
sys.stdout.buffer.write(b'fefe')
