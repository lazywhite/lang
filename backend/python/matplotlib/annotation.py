# -*- coding: utf-8 -*-
import numpy as np
import matplotlib.pyplot as plt

x = np.linspace(-3, 3, 50)
y = x * 2 + 1

plt.figure(num=1, figsize=(8, 5))
plt.plot(x, y)

ax = plt.gca()
ax.spines["right"].set_color("none")
ax.spines["top"].set_color("none")
ax.xaxis.set_ticks_position("bottom")
ax.spines["bottom"].set_position(("data", 0))
ax.yaxis.set_ticks_position("left")
ax.spines["left"].set_position(("data", 0))

x0 = 1
y0 = 2 * x0 + 1
plt.scatter(x0, y0, color="Red") # 点

plt.plot([x0, x0], [y0, 0], 'k--') # 虚线

## method 01
plt.annotate(r'$%d = 2x + 1$' % y0, xy=(x0, y0), xycoords="data", xytext=(+30, -30),
                textcoords="offset points", fontsize=16, 
                arrowprops=dict(arrowstyle='->', connectionstyle="arc3, rad=.2"))
## method 02
plt.text(-3.7, 3, "text annotation", color="red")
plt.show()
