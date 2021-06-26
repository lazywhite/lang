# -*- coding: utf-8 -*-
import re
'''
# search: 匹配可以在字符串中间, 找到第一个匹配直接返回
# match: 匹配必须从字符串开头开始

# findall: 返回list
# finditer: 返回iterator
https://docs.python.org/2/library/re.html


flags:
    re.S| re.DOTALL  默认'.' 不会匹配\n, 开启后可匹配到
    re.M| re.MULTILINE  默认'^,$'仅匹配整个字符串, 开启后匹配到每一行
    re.I| re.IGNORECASE  默认区分大小写, 开启后不区分
    
非贪婪匹配
    text2 = 'Computer says "no." Phone says "yes."'
    p = re.compile(r'\"(.*?)\"')
    p.search(text2)
'''


'''
\d: [0-9]
\D: [^0-9]
\s: [\f\n\r\t\v]
\S: [^\f\n\r\t\v]
\w: [A-Za-z0-9]
\W: [^A-Za-z0-9]
[^abk]: no 'a' or 'b' or 'k'
+: 1 or more
*: 0 or more

'''

st = 'abcdabbbb, abbb'

p = 'ab+'
m1 = re.search(p, st)
 
m2 = re.match(p, st) 

#print dir(m2)
print m2.group()


print m1.group()
#print dir(m1)

m = re.findall(p, st)

print m


s = "Bob Deline"
p = re.compile(r'(?P<name>\w*)\s+(?P<surname>\w*)')
g = p.match(s)
print g.groupdict()


# ()决定是否保留分割符
re.split('\W', 'foo/bar spam\neggs')
re.split('(\W)', 'foo/bar spam\neggs')

