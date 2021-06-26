# delegating attribute access (proxy)
class A:
    def spam(self, x):
        print(x)

class B:
    def __init__(self):
        self._a = A()

    #def spam(self, x):
    #    return self._a.spam(x)
    def __getattr__(self, name):
        ''' if there are many methods to delegete, 
        alternative approach is define this method
        get called if code tried to access an attribute
        that doesn't exist
        '''
        return getattr(self._a, name)

b = B()
b.spam(10)

class Proxy:
    def __init__(self, obj):
        self._obj = obj

    def __getattr__(self, name):
        return getattr(self._obj, name)

    def __setattr__(self, name, value):
        if name.startswith('_'):
            super().__setattr__(name, value)
        else:
            setattr(self._obj, name, value)

    def __delattr__(self, name):
        if name.startswith('_'):
            super().__delattr__(name)
        else:
            delattr(self._obj, name)

class Spam:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def bar(self):
        print(self.x, self.y)

s = Spam(2,3)

p = Proxy(s)
p.bar()
