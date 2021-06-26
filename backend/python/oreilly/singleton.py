#!/usr/bin/python

class Singleton(object):
    '''
        cache the only instance 
    '''
    def __new__(cls, *args, **kwargs):
        if not hasattr(cls, '_instance'):
            orig = super(Singleton, cls)
            cls._instance = orig.__new__(cls, *args, **kwargs)
        return cls._instance

class MyClass(Singleton):
    a = 1


one = MyClass()
two = MyClass()

two.a = 3
print one.a

class Borg(object):
    '''
        every instance share the same attr dict
    '''
    _state = {}
    
    def __new__(cls, *args, **kw):
            ob = super(Borg, cls).__new__(cls, *args, **kw)
            ob.__dict__ = cls._state
            return ob

class subBorg(Borg):
    a = 1

m = subBorg()
m.attr1 = 'k1'
m.attr2 = 'k2'

n = subBorg()
print n.__dict__
