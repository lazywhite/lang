# -*- coding: utf-8 -*-
'''
元类可以是任何callable的对象, 不限于function, class, 或是type, 只要能接受
(clsName, parents, attrs) 并返回一个类对象, 就叫元类

class XX:
    pass
实际会调用metaclass创建一个类实例, 默认是type

python2.7
    手动指定元类
        class Foo:
            __metaclass__ = xx
    全局设置
        __metaclass__ = xx

python3.x
    class Foo(Bar, metaclass=XX):
        pass
'''

'''
1. 用函数作为元类
'''
def upper_attr(future_class_name, future_class_parents, future_class_attr):
    attrs = ((name, value) for name, value in future_class_attr.items() 
            if not name.startswith('__'))
    uppercase_attr = dict((name.upper(), value) for name, value in attrs)
    return type(future_class_name, future_class_parents, uppercase_attr)


class Foo:
    foo = 'foo'

class Bar(Foo):
    __metaclasss__ = upper_attr
    bar = "bar"

print dir(Bar)


'''
2. 用类作为元类
'''
class UpperAttrMetaclass(type):
    def __new__(cls, name, bases, dct):
        '''
        bases: tuple
        '''
        attrs = ((name, value) for name, value in dct.items() if not name.startswith('__'))
        uppercase_attr=dict((name.upper(),value) for name, value in attrs)
        print "metaclass name: ", cls
        print "class name: ", name
        print "class parents: ", bases
        print "class attrs: " , dct
        return super(UpperAttrMetaclass, cls).__new__(cls, name, bases, uppercase_attr)



class Bar(object):
    __metaclass__ = UpperAttrMetaclass
    bar = 'bar'

print dir(Bar)
