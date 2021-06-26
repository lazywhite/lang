# -*- coding: utf-8 -*-
import numpy as np
import matplotlib.pyplot as plt

from mpl_toolkits.mplot3d import Axes3D


fig = plt.figure()
ax = Axes3D(fig)

x = np.arange(-4, 4, 0.25)
y = np.arange(-4, 4, 0.25)
x, y = np.meshgrid(x, y)
r = np.sqrt(x ** 2 +  y ** 2)
z = np.sin(r)
ax.plot_surface(x, y, z, rstride=1, cstride=1, cmap=plt.get_cmap('rainbow'))
'''
rstride: row stride
cstride: column stride
cmap: color map
'''


'''
等高线
offset最好要跟zlim的第一个点相同
'''
ax.contourf(x, y, z, zdir='z', offset=-5, cmap="rainbow")
ax.set_zlim(-5, 2)  
'''
zdir:  投影轴
'''
ax.contourf(x, y, z, zdir='x', offset=-5, cmap="rainbow")
ax.set_xlim(-5, 5)  

ax.contourf(x, y, z, zdir='y', offset=5, cmap="rainbow")
ax.set_ylim(-5, 5)  

plt.show()
