from cStringIO import StringIO
# python3  from io import StringIO
a = StringIO()
a.write('first line\n')
# a.seek(0)
print >>a, 'second line\n')
print a.getvalue()
a.close()
