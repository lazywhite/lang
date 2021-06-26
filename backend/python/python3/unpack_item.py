# unpacking a sequnce into seperate variables
a, b, c = (1, 2, [1,2,3])
a, b, *c = range(10)
a, *b, c = range(10)

# variable function parameters
def f(a, *args): # type(args) --> list
    pass

def f(a, **kwargs): # type(kwargs) --> dict
    pass

# define keyword only args
def f(a, *, b, c):
    print(a,b,c)

f(1,b=2,c=3)


## unpack list
def echo(name, age):
    print(name)
    print(age)


info = ['bob', 12]
echo(*info)

info2 = {
        "name": "bob",
        "age": 12
        }
echo(**info2)


## assignment unpacking

a = [ 1, 2, 3, 4 ]
b, c, *d = a
_, e, f, _ = a
print(d)
print(e)
print(f)
