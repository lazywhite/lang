from enum import Enum
from enum import unique

# make class enumeratable

class A(Enum):
    a = 10
    b = 20
    c = 10

for i in A:
    print(i)

@unique
class B(Enum):
    a = 10
    b = 20

for i in B:
    print(i)


test = Enum('test', ['good', 'bad'])
# or
#test = Enum('test', ('good', 'bad'))

test.__members__
