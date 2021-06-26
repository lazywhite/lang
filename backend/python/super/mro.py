class A(object):
    def foo(self):
        print 'a foo', id(self)


class B(A):
    def foo(self):
        print 'b foo', id(self)
        super(B,self).foo()


class C(A):
    def foo(self):
        print 'c foo', id(self)
        super(C,self).foo()

class D(B,C):
    def foo(self):
        print 'd foo', id(self)
        super(D,self).foo()


d=D()
'''
    super指MRO中的下一个类
    d.foo() --> B.foo() --> C.foo() --> A.foo()
'''
print D.__mro__
d.foo()
