import math

class Integer:
    def __init__(self, name):
        self.name = name 
        self._value = None
    def __get__(self, instance, cls):
        print('getting attr')
        return self._value

    def __set__(self, instance, value):
        print('setting attr')
        self._value = value

    def __delete__(self, instance):
        print('deleting attr')
        self._value = None

class Pair:
    x = Integer('x')
    y = Integer('y')
    def __init__(self, x, y):
        self.x = x 
        self.y = y

p = Pair(2,3)

# property is invoked by __getattribute__

# lazy computed property
class LazyProperty:
    def __init__(self, func):
        self.func = func

    def __get__(self, instance, cls):
        if instance is None:
            return self
        else:
            value = self.func(instance)  # area(instance)
            print(instance.radius)
            setattr(instance, self.func.__name__, value)
            return value

class Circle:
    def __init__(self, radius):
        self.radius = radius

    @LazyProperty
    def area(self):
        print('computing area')
        return round(math.pi * self.radius ** 2, 2)


c = Circle(3)
print(c.area)
