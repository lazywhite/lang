from io import StringIO

s = StringIO()
s.write('hello\n')
print('test\n', file=s)
print(s.getvalue())
s.close()

y = StringIO('haha\nfje\n')

for i in y.readlines():
    print(i,  end='')
