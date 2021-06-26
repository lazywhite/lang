'''
    bisect algorithm, keep a list sorted when manipulated
'''
import bisect
a = [10, 8, -1, 3]
a.sort()
bisect.insort(a, 100)
bisect.insort(a, 1)
bisect.insort(a, 4)
print(a)
