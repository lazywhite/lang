# -*- coding: utf-8 -*-
import pandas as pd
import numpy as np

'''
Tips
    pd.get_option("display.max_columns")
    pd.set_option(key, value)
    pd.reset_option(key)
    pd.describe_option(key)
    pd.option_context()

    pd.date_range('20100101', '20130101', periods=6)
    pd.RangeIndex(1, 10, 1)
    删除DataFrame列
        del d['age']
        d.pop('salary')

Series 创建
    pandas.Series( data, index, dtype, copy) 
    pd.Series([1, 2, 3], index=["x", "y", "z"])
    pd.Series(np.array(["a", "b", "c"]))
    pd.Series({"a": 1, "b": 2, "c": 3})  dict key为index, value为element
    pd.Series(5, index=[101, 102, 103]) 

DataFrame 创建
    pandas.DataFrame( data, index, columns, dtype, copy)
    pd.DataFrame([1, 2, 3])
    pd.DataFrame([["alice", 10], ["bob", 20]], columns=["name", "age"], dtype=float)
    pd.DataFrame({'Name':['Tom', 'Jack', 'Steve', 'Ricky'],'Age':[28,34,29,42]}, index=["user1", "user2", "user3", "user4"])
    pd.DataFrame([{'a': 1, 'b': 2}, {'a': 5, 'b': 10, 'c': 20}], index=["row1", "row2"])
    pd.DataFrame({'one' : pd.Series([1, 2, 3], index=['a', 'b', 'c']), 
      'two' : pd.Series([1, 2, 3, 4], index=['a', 'b', 'c', 'd'])})
        

DataFrame
    统计
        count() number of not null
        sum() 
        mean()
        median()
        mode()
        std() 
        min()
        max()
        abs()
        prod()
        cumsum()
        cumprod()
    select data
	loc() # select by label
	iloc() # select by position
	ix() #  mixed selection

    遍历
        iteritems()
        itertuples()
        iterrows()
    绘图
	plot() 折线图
	bar() 竖直方向
	barh() 水平方向
	hist()直方图
	box()
	area()
	pie()
	scatter()


Panel 创建
    1. ndarray
        data = np.random.rand(2,4,5)
        p = pd.Panel(data)
    2. dict of DataFrame
        data = {'Item1' : pd.DataFrame(np.random.randn(4, 3)), 
                'Item2' : pd.DataFrame(np.random.randn(4, 2))}
        p = pd.Panel(data) 
           

Panel
    属性
	T
	axes
	dtypes
	empty
	ndim
	shape
	size
	values
    统计
	head()
	tail()	
	mean()
	max()
	min()
	count()
	median() 平均值
	mod()
	std()
	abs()
	prod()
	consum()
	comprod()

    排序
	sort_index() 排序

    selecting data
        loc() # select by label
        iloc() # select by position
        ix() #  mixed selection


数据导入
	pd.read_csv("file", names=[], skiprow=1)
        read_excel
        sql
        json
        msgpack
        html
        pickle

'''

'''
df.index
df.columns
df.describe()
df.loc[:,["colA", "calB"]]  select a, b from table
df.loc["line label",["colA", "calB"]] select a, b from line
df.loc[["line1", "line2"],["colA", "calB"]] select a, b from line
df.iloc[[1, 2, 3], 1:3] 
df.iloc[1:3, 1:3] 
df[df.A > 8]
'''
