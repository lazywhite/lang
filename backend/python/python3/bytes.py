## python3.5
>>> a = b"{\"k1\":100}"
>>> type(a)
<class 'bytes'>
>>> b = a.decode('utf-8')
>>> b
'{"k1":100}'
>>> type(b)
<class 'str'>
>>> c = json.loads(b)
>>> c
{'k1': 100}
>>> type(c)
<class 'dict'>

