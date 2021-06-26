import gevent
from gevent import getcurrent
from gevent.pool import Group

group = Group()
def hello_from(n):
    print('size of group: %s' % len(group))
    print('hello from Greenlet: %s' % id(getcurrent()))

group.map(hello_from, range(3))
group.join()
