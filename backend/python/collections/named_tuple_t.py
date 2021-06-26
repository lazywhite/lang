## namedtuple is a replacement of dict, and is immutable
from collections import namedtuple
Subscriber = namedtuple('Subscriber',['addr', 'joined'])
sub = Subscriber('a@b.com', joined='2010-10-11')
print(sub)
sub=sub._replace(addr='a@4.com')
print(sub)

Stock = namedtuple('stock',['name', 'shares', 'price', 'date', 'time'])
stock_proto = Stock('', 0, 0.0, None, None)
def dict_to_stock(s):
    return stock_proto._replace(**s)
a = {'name': 'ACME', 'shares': 100, 'price': 123.45}
print(dict_to_stock(a))

