# -*- coding: utf-8 -*-
#!/usr/bin/env python
class Demo(object):
    '''class document'''

    '''
    __slots__ = 

    可以接受单个string, iterable, 或string列表
    如果在新式类里定义此属性, 则不会为instance创建__dict__, __weakref__属性
    '''
    '''
    __metaclass__
    可以是任何接受name, bases, dict 参数的callable, 只要能返回一个类
    默认是type()

    '''
    def foo(self):
        pass

    def __new__(cls, *args, **kwargs):
        '''
            新式类才有此方法
            不必声明为@classmethod
        '''
        print 'a new instance is about to be created'
        return super(Demo, cls).__new__(cls, *args, **kwargs)

    def __init__(self, name=None):
        '''
            called when instance is initialized
        '''
        self.name = name
        print 'instance created'
    
    def __del__(self):
        '''
            called when instance is about to be destroyed
        '''
        print 'instance deleted'

    def __hash__(self):
        '''called by hash()'''
        return super(Demo, self).__hash__();

    def __format__(self):
        '''
            called by format()
        '''
        pass

    def __bool__(self):
        '''called by bool()'''
        pass

    def __repr__(self):
        '''called by repr()
        '''
        return 'Demo: ' + self.name

    def __str__(self):
        '''called by str() and "print"
        '''
        return 'Demo: ' + self.name

    '''
    Rich comparison
    '''
    def __lt__(self, other):
        ''' less than'''
        if isinstance(other, Demo):
            return self.name < other.name
        return None

    def __le__(self, other):
        ''' less than or equal'''
        if isinstance(other, Demo):
            return self.name <= other.name
        return None

    def __eq__(self, other):
        pass
    
    def __ne__(self, other):
        pass

    def __gt__(self, other):
        pass

    def __ge__(self, other):
        pass

    def __cmp__(self, other):
        '''
        called by comparison operations if Rich comparison is not defined,
        should return a number 

        if no __cmp__(), __eq__(), __ne__() is defined, class instances is 
        compared by object identity(address) id(obj)
        '''
    def __nonzero__(self):
        '''
        called to implement truth value testing and the bool()
        should return True, False, 0, 1
        fallback
            __len__()
            
        '''

    def __unicode__(self):
        '''
        called by unicode(), should return a unicode object
        '''

    '''
    customizing attribute access, 重写以改变系统默认的属性访问行为
    '''
    def __getattr__(self, name):
        '''
        '''
        pass

    def __setattr__(self, name, value):
        pass

    def __delattr__(self, name):
        pass

    def __getattribute__(self, name):
        '''
        只能用在新式类, 如果定义了此方法, 即使__getattr__被定义也不会被调用
        除非被显式调用, 或者抛出AttributeError
        '''
        pass

    '''
    Descriptor 接口
    '''
    def __get__(self, instance, owner):
        pass
    
    def __set__(self, instance, value):
        pass

    def __delete__(self, value):
        pass

    '''
    类型检查
    '''
    def __instancecheck__(self, instance):
        '''called by isinstance(istance, class)'''
        pass

    def __subclasscheck__(self, subclass):
        '''called by issubclass(subclass, class)
        '''
        pass

    def __call__(self, *args, **kwargs):
        '''
        make instance callable
        '''
        pass

    '''
    模拟容器类型
    '''
    def __len__(self):
        pass

    def __getitem__(self, key):
        '''
        called when using self[key]
        '''
        pass

    def __setitem__(self, key, value):
        '''
        called when using self[key] = value
        '''
        pass

    def __delitem__(self, key):
        pass

    def __iter__(self):
        '''should return an iterator type
        called by iter()
        '''

    def __reversed__(self):
        '''called by reversed()'''
        pass

    def __contains__(self, item):
        '''called by "in" test '''

    def __missing__(self, key):
        pass

    '''
    序列类型模拟
    '''
    def __getslice__(self, i, j):
        pass

    def __setslice__(self, i, j, sequence):
        pass

    def __delslice__(self, i, j, sequence):
        pass
    '''
    模拟数字类型
    __add__
    __sub__
    __mul__
    __floordiv__
    __mod__
    __divmod__
    __pow__
    __lshift__
    __rshift__
    __and__
    __xor__
    __or__
    __div__
    __truediv__
    __radd__
    __rsub__
    __rmul__
    __rdiv__
    __rtruediv__
    __rfloordiv__
    __rmod__
    __rdivmod__
    __rpow__
    __rlshift__
    __rrshift__
    __rand__
    __rxor__
    __ror__
    __iadd__
    ...
    '''

    '''
    with协议
    __enter__(self)
    __exit__(self, exc_type, exc_value, traceback)
    '''


a = Demo("a")
b = Demo("b")
'''
a.__doc__: fu
a.foo.__doc__: function docString
a.foo.__name__: function name
a.foo.__qualname__: function qualified name, new in python3
a.foo.__module__: moduel name where function is defined
a.foo.__defaults__: a tuple contains all function default argument values
a.foo.__code__: a code object represent the compiled function body
a.foo.__dict__: namespace holding function attributes 
'''
print a < b
