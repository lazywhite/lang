# -*-  coding: utf-8 -*-
#!/usr/bin/env python
from __future__ import print_function
## 没有object, 就是老式类, 子类调用父类__init__()会出错
class Foo(object):
    def __init__(self, name):
        print("Foo created")
        self.name = name

    def say(self):
        print('foo printed')

class Bar(Foo):
    def __init__(self, name=None, age=None):
        '''
            用super调用父类构造方法
        '''
        super(Bar, self).__init__(name)
        self.age = age

    def say(self):
        '''
            super调用父类同名函数
        '''
        super(Bar, self).say()
        print('bar printed')


b = Bar("bob", 10)
b.say()
print(b.name, b.age)
