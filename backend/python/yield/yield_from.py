#def sub():
#    tally = 0
#    while True:
#        next = yield
#        if next is None:
#            return tally
#        tally += next

#def master(tallies):
#    tally = yield from sub()
#    tallies.append(tally)
#    print(tallies)

#tallies = []

#acc = master(tallies)

#try:
#    acc.send(None)
#    for i in range(4):
#        acc.send(i)


#    acc.send(None)
#except StopIteration:
#    pass

# ======================================
def m():
    for i in range(3):
        if not int(i) == 2:
            yield i
        else:
            return 33

def f():
    while 1:
        result = yield from m()
        print(result)
g = f()
print(type(g))

