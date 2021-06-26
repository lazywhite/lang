# simplify the initializing of Data Structures
class Structure:
    _fields = []
    def __init__(self,*args):
        if len(self._fields) != len(args):
            raise TypeError('Except {} arguments'.format(len(self._fields)))
        for name, value in zip(self._fields, args):
            setattr(self, name, value)

class Stock(Structure):
    _fields = ['name', 'share', 'price']

class Points(Structure):
    _fields = ['x', 'y']

a = Stock(1,2,3) 
print(a.name, a.share, a.price)


# create instances in more than one way provided by __init__
# use classmethod
# one of the primary use of class method is to define alternate
# constructer 
import time

class Date:
    def __init__(self, year, month, day):
        self.year = year
        self.month = month
        self.day = day

    @classmethod
    def today(cls):
        t = time.localtime()
        return cls(t.tm_year, t.tm_mon, t.tm_mday)

a = Date(2012,3,5)
b = Date.today() #this will also create a Date instance

# create a data structure with lots of types, and 
#visit this data structure, process each data with 
#correspond function

class Node:
   pass
class UnaryOperator(Node):
   def __init__(self, operand):
       self.operand = operand
class BinaryOperator(Node):
   def __init__(self, left, right):
       self.left = left
       self.right = right
class Add(BinaryOperator):
   pass
class Sub(BinaryOperator):
   pass
class Mul(BinaryOperator):
   pass
class Div(BinaryOperator):
   pass
class Negate(UnaryOperator):
   pass
class Number(Node):
   def __init__(self, value):
       self.value = value
# Representation of 1 + 2 * (3 - 4) / 5
t1 = Sub(Number(3), Number(4))
t2 = Mul(Number(2), t1)
t3 = Div(t2, Number(5))
t4 = Add(Number(1), t3)

class NodeVisitor:
   def visit(self, node):
       methname = 'visit_' + type(node).__name__
       meth = getattr(self, methname, None)
       if meth is None:
           meth = self.generic_visit
       return meth(node)

   def generic_visit(self, node):
       raise RuntimeError('No {} method'.format('visit_'+type(node).__name__))

class Evaluator(NodeVisitor):
   def visit_Number(self, node):
       return node.value
   def visit_Add(self, node):
       return self.visit(node.left) + self.visit(node.right)
   def visit_Sub(self, node):
       return self.visit(node.left) - self.visit(node.right)
   def visit_Mul(self, node):
       return self.visit(node.left) * self.visit(node.right)
   def visit_Div(self, node):
       return self.visit(node.left) / self.visit(node.right)
   def visit_Negate(self, node):
       return -node.operand

e = Evaluator()
print(e.visit(t4))

