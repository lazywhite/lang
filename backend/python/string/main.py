# -*- coding: utf-8 -*-
#
# Copyright © 2018 white <white@Whites-Mac-Air.local>
#
# Distributed under terms of the MIT license.

"""
"""
import string

a = string.Template("name is $name, hello $name")
a.substitute({"name": "bob"})

