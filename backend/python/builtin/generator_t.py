# 一个列表有100万元素，如果元素可以推算出来，而不用一次性全部赋值，这样就可以节省大量内存
# 这就是generator的用处

# 1. 生成一个generator
# 1.1
a = (i*2 for i in range(10))
print(type(a)) # generator

b = [i*2 for i in range(10)]
print(type(b)) # list


# 1.2  generator function(必须包含yiled, 可以有多个yield
'''
1. Generator function contains one or more yield statements.
2. When called, it returns an object (iterator) but does not start execution immediately.
3. Methods like __iter__() and __next__() are implemented automatically. So we can iterate through the items using next().
4. Once the function yields, the function is paused and the control is transferred to the caller.
5. Local variables and their states are remembered between successive calls.
6. Finally, when the function terminates, StopIteration is raised automatically on further calls.
'''

# 1.2.1 有限个yield语句
def gen():
    n = 1
    yield n
    n += 1
    yield n
    n += 1
    yield n

x = gen()
print(next(x))

# 1.2.2 在循环体内的yield

def gen():
    n = 3
    while n > 0:
        print("hhhh:") # generator刚被创建时，此行之前并不会执行
        yield n
        n -= 1

x = gen()
print("after create")
for i in x:
    print(i)
