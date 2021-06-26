import heapq
from operator import itemgetter, methodcaller, attrgetter


# 1. itemgetter
# itemgetter('item')(obj) = obj['item']
# itemgetter: per object need has__getitem__
portfolio = [   
        {'name': 'IBM', 'shares': 100, 'price': 91.1},   
        {'name': 'AAPL', 'shares': 50, 'price': 543.22},
        {'name': 'FB', 'shares': 200, 'price': 21.09},
        {'name': 'HPQ', 'shares': 35, 'price': 31.75},
        {'name': 'YHOO', 'shares': 45, 'price': 16.35},
        {'name': 'ACME', 'shares': 75, 'price': 115.65}
    ]

cheap = heapq.nsmallest(3, portfolio, key=itemgetter('price'), reverse=True)
# or: cheap = heapq.nsmallest(3, portfolio, key=lambda s: s['price'])
print(cheap)


# 2. attrgetter
# attrgetter('attr')(obj) = obj.'attr'
# attrgetter: per object need __getattr__ 
class User:
    def __init__(self, uid):
        self.uid = uid

    def say(self):
        print("hello")

    def __repr__(self):
        return "User: %s" % self.uid

u = [User(100), User(20), User(101)]

print(sorted(u, key=attrgetter('uid')))

# methodcaller
# methodcaller('method', *args)(obj) = obj.method(*args)
for i in u:
    methodcaller('say')(i)

