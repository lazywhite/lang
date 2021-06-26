#!/usr/bin/python
class MyDict(dict):
    def __init__(self,default='Default'):
        dict.__init__(self)
        self.default = default
    def __getitem__(self,key):
        try:
            return dict.__getitem__(self,key)
        except KeyError:
            return self.default

a=MyDict()
b = dict()

print(a['fe'])
print(b['fe'])
