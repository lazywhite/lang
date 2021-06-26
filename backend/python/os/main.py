import os

os.remove(file)
os.mkdir(dir)
os.makedirs(dir)

os.path.isabs(path) # test whether a path is absolute
os.path.isdir(dir) 
os.path.isfile
os.path.islink
os.path.ismount
os.path.exists("/path/to/file")

path = '/usr/lib/python/a.csv'
print(os.path.basename(path))
print(os.path.dirname(path))
print(os.path.join('tmp','data',os.path.basename(path)))
path = '~/data.csv'
print(os.path.expanduser(path))
print(os.path.splitext(path))
print(os.path.exists('/etc/passwd'))
print(os.path.isfile('/etc/shadow'))
print(os.path.islink('/usr/bin/python'))
print(dir(os.path), end='\n\n')
print(os.listdir())
