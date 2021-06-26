import random

values = [1, 2, 3, 4, 5, 6]
print(random.choice(values))
print(random.sample(values, 2))
random.shuffle(values)
print(values)
random.seed(1)
print(random.random())
random.seed(1) ## same seed generate same random number
print(random.random())


print(random.sample(values, 3)) # get random K items from <collection>
print(random.randint(10, 20))
