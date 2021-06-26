# -*- coding: utf-8 -*-
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

'''
DataFrame()对象有方法k可以调用matplotlib绘图
'''

data = pd.DataFrame(np.random.randn(1000, 4), index=np.arange(1000),
                    columns=['a', 'b', 'c', 'd'])

# 散点图
ax = data.plot.scatter("a", "b", color="DarkBlue", label="class A")
data.plot.scatter("a", "c", color="DarkGreen", label="class B", ax=ax)
plt.show()

