# -*- coding: utf-8 -*-
import sqlite3

'''
db = sqlite3.connect(":memory:") # 创建内存数据库
db = sqlite3.connect("/path/to/db")
'''


stocks = [
       ('GOOG', 100, 490.1),
       ('AAPL', 50, 545.75),
       ('FB', 150, 7.45),
       ('HPQ', 75, 33.2),
       ]

db = sqlite3.connect('sqlite3.db')
c = db.cursor()
c.execute('create table portfolio (symbol text, share integer, price real)')
db.commit()
c.executemany('insert into portfolio values(?,?,?)', stocks)
db.commit()

for row in db.execute('select * from portfolio'):
   print(row)

db.close()

