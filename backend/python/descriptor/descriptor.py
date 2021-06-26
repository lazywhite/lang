class UpperString(object):
    def __init__(self):
        self._value = ''
        
    def __get__(self,instance,cls):
        print "context: ", id(instance)," ", cls.__name__
        print 'value accessed'
        return self._value

    def __set__(self,instance,value):
        print "context: ", id(instance)," ", value
        print 'value setted'
        self._value = str(value).upper()

    def __delete__(self, instance):
        print "context: ", id(instance)
        print 'deleted'


class MyClass(object):
    attribute = UpperString()


a = MyClass()
print "id of object a", id(a)
a.attribute = 'attribute value'
print a.attribute
del a.attribute
