# -*- coding: utf-8 -*-
import numpy as np
import matplotlib.pyplot as plt


n = 1024

# normal 高斯分布
x = np.random.normal(0, 1, n)
y = np.random.normal(0, 1, n)
t = np.arctan2(y, x) # for color
plt.scatter(x, y, s=25, c=t, alpha=0.5)
plt.xticks(())
plt.yticks(())
plt.xlim(-1.5, 1.5)
plt.ylim(-1.5, 1.5)
plt.show()
