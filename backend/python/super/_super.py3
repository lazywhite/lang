#!/usr/bin/env python3
'''
super()指__mro__中下一个class
'''
class Foo:
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
        super().__init__(name)
        self.age = age

    def say(self):
        '''
            super调用父类同名函数
        '''
        super().say()
        print('bar printed')


b = Bar("bob", 10)
b.say()
print(b.name, b.age)
