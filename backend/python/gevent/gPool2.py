import gevent
from gevent import getcurrent
from gevent.pool import Group

'''
imap: 返回iterator
map: 返回list, ordered
map_unordered: 
imap_unordered
'''

def intensive(n):
    gevent.sleep(3-n)
    return 'task', n

print('Ordered')
ogroup = Group()
for i in ogroup.imap(intensive, range(3)):
    print(i)

print('Unordered')
ugroup = Group()
for i in ugroup.imap_unordered(intensive, range(3)):
    print(i)

