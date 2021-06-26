#from itertools import groupby
#def compress(data):
#    return ((len(list(group)),name) for name, group in groupby(data))
#def decompress(data):
#    return (car * size for size,car in data)

#data = 'geuet uuuuuuup'

#m = list(data)
#m.sort()

#compressed = list(compress(data))


#print(compressed)

#print(''.join(decompress(compressed)))
# ===========================================
#from itertools import accumulate
#from operator import mul
#print(list(accumulate(range(10))))
#print(list(accumulate(range(1,10), mul)))
# ============================
#from itertools import chain
#print(list(chain(range(10),range(30,40))))
# ===============================
#from itertools import combinations
# C(5,2)
#print(list(combinations(range(5),2)))
# =============================
#from itertools import combinations_with_replacement
# C(5,2)+5
#print(list(combinations_with_replacement(range(5),2)))
# ==============================
#from itertools import compress
#selector = [ x > 3 for x in range(7) ]
#print(list(compress(range(7),selector)))
# ==============================
# A(3,2)
#from itertools import permutations
#print(list(permutations(range(3),2)))
# ========================================
#from itertools import product
#print(len(list(product(range(2),range(3),range(4)))))
# =======================================
#list(itertools.starmap(add,enumerate(range(10))))
# =====================================
#takewhile , dropwhile
# ===================================
# return a list of same iterator
#from itertools import tee
#a = tee(range(10),3)
#print(list(a[2]))
