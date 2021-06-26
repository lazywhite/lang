# choose an item from a dict by weight 
import random
def _pick_base_on_weight( _dict):
    total_weight = sum(_dict.values())
    rand = random.randint(0,total_weight) 
    total = 0
    for key, weight in _dict.items():
        total += weight
        if rand < total:
            return key


a = dict(k1=10, k2=20, k3=30)

print _pick_base_on_weight(a)
