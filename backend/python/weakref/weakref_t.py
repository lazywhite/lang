#! /usr/bin/env python
# -*- coding: utf-8 -*-
# vim:fenc=utf-8
#
# Copyright © 2017 white <white@localhost>
#
# Distributed under terms of the MIT license.
import time
import gc
import weakref

"""
当一个对象的引用只剩下weakref时, 这个对象就可以被垃圾回收了
在对象被真正垃圾回收之前, weak reference还是能够正确返回这个对象
"""

'''
错误方式
'''

class A(object):
    def __init__(self, name):
        self.name = name
        print "a object consuming large memory is created"  

    def __del__(self):
        print "type A object ", self.name, " get garbage collected"

a = A("a")
b = A("b")
map = dict(key1=a, key2=b)
del(a) 
gc.collect()# won't make a garbage collected
time.sleep(1)


c = A("c")
d = A("d")
map2 = weakref.WeakValueDictionary()
map2["c"] = c
map2["d"] = d

r = weakref.ref(d)
e = r()
print e is d

print "weakref count of d: ", weakref.getweakrefcount(d)


'''
register a callback when object is gced
new in python3


def callback(name):
    print "you killed ", name

weakref.finalize(d, callback, "d")
'''

del(c)
gc.collect()

time.sleep(3)
