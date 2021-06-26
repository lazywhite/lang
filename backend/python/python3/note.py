string to buffer
python2
    a = "str"
    b = buffer(a)
python3


string bytes
python2
    
python3
    a = 'string'
    type(a) --> str
    b = b'string'
    type(b) -> bytes
    c = a.encode("utf8")
    type(c) -> bytes
    d = c.decode("utf8")
    type(d) -> str
    e = u"string"
    type(e) -> str

    
