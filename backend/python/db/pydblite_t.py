# -*- coding: utf-8 -*-
from pydblite import Base
'''
序列化采用cPickle
'''

db = Base("test.db", save_to_file=False)

if db.exists():
    db.open()
else:
    db.create("name", "age")

db.insert("bob", 10)
index = db.insert(name="alice", age=20)

print db[index] # 按照主键访问record

record = db[1]

db.update(record, name="dellian")

#db.delete(record)

# db.records (所有记录)

# query
for r in db("age") > 10:
    print r


for r in (db("age") > 5 ) & (db("name") == "bob"):
    print r

print db.records
#db.commit() # flush to disk

