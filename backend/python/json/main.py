# -*- coding: utf-8 -*-
import json
data = { 
    'name' : {'first':'Lili', 
    'last':'Sende'}, 
    'share' : [1,2,100], 
    'price' : 30 
}

# dumps : serial str into json format
a = json.dumps(data)
print(a)
# loads : deserial json into python object
b = json.loads(a)
print(b)

