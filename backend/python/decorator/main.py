# -*- coding: utf-8 -*-
#
# Copyright © 2018 white <white@Whites-Mac-Air.local>
#
# Distributed under terms of the MIT license.
'''
1. 装饰器，接受一个函数为参数, 返回一个函数, 因此内部最终return一个func

def deco(func):
    def _wrapper(*args, **kwargs):
        func(*args, **kwargs)
    return _wrapper


2. 带参数的装饰器，接受参数， 返回一个装饰器, 因此有两层return

def deco(deco_arg):
    def _deco(func):
        def _wrapper(*args, **kwargs):
            func(*args, **kwargs)
        return _wrapper
    return _deco

3. 多重装饰器, 相当于deco1(deco2(func)) = new_func
@deco1
@deco2
def func():
    pass
'''

def deco1(func):
    def _wrapper():
        print("inside deco1")
        func()
    return _wrapper

def deco2(func):
    def _wrapper():
        print("inside deco2")
        func()
    return _wrapper

# 多重修饰器, 相当于deco1(deco2(func))
@deco1
@deco2
def func():
    print("test")

func()

# 带参数的修饰器
def deco3(arg):
    def _deco(func):
        print("deco arg:",  arg)
        def _wrapper(*args, **kwargs):
            print("inside deco3")
            func(*args)
        return _wrapper
    return _deco


@deco3(100)
def fun(*args, **kwargs):
    print(args)
    print(kwargs)


'''
类的staticmethod, classmethod, 成员函数, 跟普通函数的区别仅仅是参数数量不同而已
'''
class Test:
    @deco3(200)
    def run(self, arg1, arg2):
        print(arg1, arg2)


Test().run(10, 20)
