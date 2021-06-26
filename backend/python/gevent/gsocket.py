import socket
print(socket.socket)
import time
print(time.sleep)
import select
print(select.select)

from gevent import monkey;monkey.patch_all()
print(socket.socket)
print(select.select)
print(time.sleep)

import gevent
import urllib2


def fetch(pid):
    response = urllib2.urlopen('http://www.baidu.com')
    result = response.read()
    print('Process %s' % pid)

def sync():
    for i in range(5):
        fetch(i)

def async():
    threads = []
    for i in xrange(5):
        threads.append(gevent.spawn(fetch, i))
    gevent.joinall(threads)

sync()
async()
