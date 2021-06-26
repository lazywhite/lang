def test(*args):
    a = 10 # (A)
    def _wrapper(n):
        #The nonlocal keyword allows us to modify a variable with immutable type in the outer function scope.
        nonlocal a  # 必须有此声明，才能修改A处变量值
        a += 2
        return n + a
    return _wrapper

# 闭包, 支持多个实例(x和y)，每个实例独立保存自己的变量
x = test() 
print(x(10)) # 22
print(x(20)) # 34

y = test()
print(y(30)) # 42
print(y(40)) # 56


# 每次调用test()就创建了一个新闭包实例
print(test()(10)) # 22
print(test()(20)) # 32



# 装饰器就是一种闭包应用, 只不过传递的是函数
def make_bold(fn):
    def _wrapper():
        return "<b>" + fn() + "<b>"
    return _wrapper

def make_italic(fn):
    def _wrapper():
        return "<i>" + fn() + "<i>"
    return _wrapper

@make_bold
@make_italic
# 就近原则，italic最先起作用
def hello():
    return "hello"

print(hello())
print(make_bold(hello)())
