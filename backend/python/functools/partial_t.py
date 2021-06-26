from functools import partial


def full(name=None, email=None, uid=None):
    print(name, email, uid)


full('jam', 'abc@123.com', 100)

name_partial = partial(full, email="add@mm.com", uid=1010)
name_partial('bob')
