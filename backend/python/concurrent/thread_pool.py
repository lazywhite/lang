from concurrent.futures import ThreadPoolExecutor
import time

def foo(arg1, arg2):
    time.sleep(1)
    return arg1 + arg2


with ThreadPoolExecutor() as executor:
    futures = [executor.submit(foo, i, i) for i in range(10)]
    results = [f.result() for f in futures]

print(results)
print("exiting")
