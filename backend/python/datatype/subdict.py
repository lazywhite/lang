#!/usr/bin/python
'''
    this module can create a dict type that you can't insert 
    a key:value if value already exists
'''

class DictError(Exception):
    pass


class MyDict(dict):
    def __setitem__(self, key, value):
        try:
            value_index = self.values().index(value)
            existing_key = self.keys()[value_index]
            if existing_key != key:
                raise DictError(("this value already exists for '%s'") % \
                                str(self[existing_key]))
        except ValueError:
            pass
        super(MyDict,self).__setitem__(key,value)

my = MyDict()

my['key'] = 'value'
my['other_key'] = 'value'
