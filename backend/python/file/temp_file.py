from tempfile import TemporaryFile 

with TemporaryFile('w+t') as f:
    f.write('hello\n')
    f.seek(2)
    data = f.read()
    print(data)

