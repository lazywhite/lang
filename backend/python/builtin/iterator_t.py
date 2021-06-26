# iterator object must implement two special methods, __iter__() and __next__(), collectively called the iterator protocol.
# An object is called iterable if we can get an iterator from it
# 可以对一个iterator执行next()方法，或者for loop, 如果耗尽会raise StopIteration

# 1. 如何获得一个iterator object
# 1.1 直接对list, tuple, set, dictionary, string调用iter()
a = list(range(10))
b = iter(a)
print(type(b)) # --> list_iterator

c = range(10)
d = iter(c)
print(type(d)) # --> range_iterator

# 1.2 自己实现一个iterator

class MyNumbers:
  def __iter__(self):
    self.a = 1
    return self

  def __next__(self):
    x = self.a
    self.a += 1
    return x

myclass = MyNumbers()
myiter = iter(myclass)

print(next(myiter))
