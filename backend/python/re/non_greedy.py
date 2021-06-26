# -*- coding: utf-8 -*-
import re
with open("base") as f:
    data = f.read()

p = re.compile(r"Onboard Device(.*?)Type Instance: (?P<number>[^\n]*)", re.DOTALL)

for m in p.finditer(data):
    print  m.groupdict()

