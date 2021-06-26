# -*- coding: utf-8 -*-
#
# Copyright © 2018 white <white@Whites-Mac-Air.local>
#
# Distributed under terms of the MIT license.

"""
https://hdfscli.readthedocs.io/en/latest/api.html#module-hdfs.client
"""
from hdfs import InsecureClient

hdfs_url = "http://192.168.30.125:50070"
hdfs_user = "root"
c = InsecureClient(hdfs_url, user=hdfs_user)

c.write("/test_write", data="string")
c.delete("/test_write")
c.makedirs("/new/path") # 自动递归创建

with c.read("f.txt", encoding="utf-8") as f:
    content = f.read()

c.write("/test.txt", "test string")
