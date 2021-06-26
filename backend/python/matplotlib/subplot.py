# -*- coding: utf-8 -*-
import numpy as np
import matplotlib.pyplot as plt
import matplotlib.gridspec as gridspec


#fig = plt.figure()
### 通过subplot创建
'''
plt.subplot(3, 2, 1) # 切分为3行2列
plt.plot([0, 1], [0, 1])

plt.subplot(3, 2, 2) # 切分为3行2列
plt.plot([0, 1], [0, 1])

plt.subplot(3, 2, 3) # 切分为3行2列
plt.plot([0, 1], [0, 1])
'''
'''
切分为2x3格, 根据格号绘图
plt.subplot(2, 1, 1) # 
plt.plot([0, 1], [0, 1])
plt.subplot(2, 3, 4) # 
plt.plot([0, 1], [0, 1])
plt.subplot(2, 3, 5) # 
plt.plot([0, 1], [0, 1])
plt.subplot(2, 3, 6) # 
plt.plot([0, 1], [0, 1])
'''

### 通过grid创建
'''
gs = gridspec.GridSpec(3, 3)

ax1 = plt.subplot(gs[0, :])
ax2 = plt.subplot(gs[1, :2])
ax3 = plt.subplot(gs[1:, 2])
ax4 = plt.subplot(gs[-1, 0])
ax4 = plt.subplot(gs[-1, -2])
'''

## 通过subplots
fig, ((ax11, ax12), (ax21, ax22)) = plt.subplots(2, 2, sharex=True, sharey=True)
'''
sharex 共享x轴 ticks
sharey 共享y轴 ticks
'''

plt.show()
