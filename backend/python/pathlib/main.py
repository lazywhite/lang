'''
    object oriented filesystem types
'''
from pathlib import Path
p = Path('/Users/rock')

for i in p.iterdir():
    print(i)

print(p.as_uri())

d = p/'Documents'/'py'
print('status:',d.stat())

for i in d.glob('*.py'):
    print('file globbing: ', i)

print('========= usefull attribute and method =======')
for i in dir(d):
    if not i.startswith('_'):
        print(i)
