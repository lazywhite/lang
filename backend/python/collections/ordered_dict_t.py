# OrderedDickt can exactly preserve the insertion order of items  
# it use linked list to store the order information, and consume 
# twice the size of normal dict
from collections import OrderedDict

# OrderedDict is useful in object serialization

d= OrderedDict()
d['foo'] = 1
d['bar'] = 4
d['spam'] = 3
d['grok'] = 2


print(d)
