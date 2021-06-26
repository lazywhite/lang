import pdb

def counter(maxium):
    i = 0
    while i < maxium:
        val = (yield i)
        if val is not None:
            i = val
        else:
            i += 1
pdb.set_trace()
gen = counter(10)
print(next(gen))
print(next(gen))
print(next(gen))
print(next(gen))
gen.send(6)

print(next(gen))
