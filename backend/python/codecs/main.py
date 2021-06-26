'''
TypeError: 'str' does not support the buffer interface
'''
import codecs
a = 'hello'
b = codecs.encode(a, 'utf-8')
print(codecs.decode(b, 'utf-8'))

c = b'hello'
print(type(c))
d = codecs.encode(c, 'hex')
print(codecs.decode(d, 'hex'))


e = codecs.encode(c, 'zip')
print(codecs.decode(e, 'zip'))
