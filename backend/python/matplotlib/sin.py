# -*- coding: utf-8 -*-
import numpy as np
import matplotlib.pyplot as plt

from mpl_toolkits.mplot3d import Axes3D


fig, ax = plt.subplots()
x = np.arange(-2*np.pi, 2*np.pi, 0.01)
ax.spines["right"].set_color("none")
ax.spines["top"].set_color("none")
ax.xaxis.set_ticks_position("bottom")
ax.spines["bottom"].set_position(("data", 0))
ax.yaxis.set_ticks_position("left")
ax.spines["left"].set_position(("data", 0))

plt.ylim(-2, 2)

line, =  plt.plot(x, np.sin(x))

plt.show()
