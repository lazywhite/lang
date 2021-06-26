# -*- coding: utf-8 -*-
#
# Copyright © 2018 white <white@Whites-Mac-Air.local>
#
# Distributed under terms of the MIT license.


class A:
    _instance = None
    def __new__(cls, *args, **kwargs):
        if not cls._instance:
            cls._instance = super().__new__(cls, *args, **kwargs)
        return cls._instance


a = A()
print(id(a))
b = A()
print(id(b))


