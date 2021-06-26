class MyClass(object):
    def __init__(self):
        self._secret_thing = 1


    def _i_get(self):
        print "getter"
        return self._secret_thing

    def _i_set(self, value):
        print "setter"
        self._secret_thing = value

    def _i_delete(self):
        print "deleter"

    my_thing = property(_i_get, _i_set, _i_delete, 'property description')



class B(object):
    '''
    setter, deleter方法名必须跟属性同名
    只有getter, 没有setter无法对属性进行赋值

    setter需要额外定义, 默认不包含
    '''
    def __init__(self, first_name):
        self.first_name = first_name

    @property
    def first_name(self):
        return self._first_name

    @first_name.setter
    def first_name(self, value):
        self._first_name = value

    @first_name.deleter
    def first_name(self):
        self._first_name = None


a = MyClass()
print a.my_thing
a.my_thing = 10
print a.my_thing
del(a.my_thing)

b = B('bob')
print b.first_name	
