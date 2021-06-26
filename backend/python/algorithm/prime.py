# 求10亿内素数和
import math  
from operator import add
from functools import reduce
def prime(n):  
    primes = [2]  
    primet = [2]  
    for x in range(3,n+1,2):  
        if primet[-1] ** 2 < x:  
            primet.append(primes[len(primet)])  
        for i in primet:  
            if x % i == 0:  
                break  
        else:  
            primes.append(x)  
    return primes  

print(reduce(add, prime(1000000000)))


# 24739512092254535
