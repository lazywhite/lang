def f(n):
    if n > 5:
        return True
    else:
        return False


a = range(10)


print(filter(f, a))
