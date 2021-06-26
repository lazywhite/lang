from decimal import Decimal
import math


# 1.round(number[, ndigital]) always return a float number

print(round(1.2235,3))
print(round(1.22325,-1))
print(round(122325,-1))



# 2. Decimal
a = Decimal('2.1')
b = Decimal('2.2')

print(a + b)
if (a+b) == 4.3:
    print('false')
elif (a+b) == Decimal('4.3'):
    print('true')


# 3. special numbers 
a = float('inf')
b = float('-inf')
c = float('nan')
print(a,b,c)
print(type(a), type(b), type(c))

print(math.isinf(a))
print(math.isinf(b))
print(math.isnan(c))
