from __future__ import print_function

import cx_Oracle


# 防止insert, update中文乱码
import os
os.environ['NLS_LANG'] = 'SIMPLIFIED CHINESE_CHINA.UTF8'
os.environ['LANG'] = 'zh_CN.UTF8'


connection = cx_Oracle.connect("user", "password", "10.0.0.18:1521/db")
#connection.autocommit = True

print(connection.version)
cursor = connection.cursor()

# sql语句不能以;结尾
cursor.execute("""
    SELECT colA, colB
    FROM user_table""")

rows = cursor.fetchall()
for row in rows:
    print(row)

sql = '''insert into user_table2(colA, colB) values (:1, ':2')'''
cursor.executeman(sql, rows)
connection.commit()

connection.close()
