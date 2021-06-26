from collections import defaultdict

## defaultdict(default_factory[,...])
## default_factory is called without arguments to produce a new value 
## and create that entry with that value

def defa():
    return 'default value'

c = defaultdict(defa, foo='foo')
print(c['foo'])
print(c['bar'])

d = defaultdict(list)
d['a'].append(1)
d['a'].append(2)
d['b'].append(1)
print(d)


d = defaultdict(set)
d['a'].add(1)
d['a'].add(2)
d['b'].add(2)
print(d)
print(d['c'])
print(d)
