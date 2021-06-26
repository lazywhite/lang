# -*- coding: utf-8 -*-
import numpy as np
import matplotlib.pyplot as plt
'''
plot
figure
label
legend

中文字体
特殊符号

'''

x = np.linspace(-3, 5, 50)
y1 = x * 2 + 1
y2 = x ** 2

'''
用不同的图绘制
plt.figure()
plt.plot(x, y1)

plt.figure()
plt.plot(x, y2, color="red", linewidth=.4, linestyle='--')
plt.show()
'''
plt.figure()
l1, = plt.plot(x, y1, label="line1")
l2, = plt.plot(x, y2, color="red", linewidth=.4, linestyle='--', label="line2")

'''
设置图中值的取值范围
'''
# plt.xlim(-2, 2)
# plt.ylim(-2, 2)
'''
设置x, y label
'''
plt.xlabel("I am x")
plt.ylabel("I am y")
#x_ticks = np.linspace(1, 9, 1)
#plt.xticks(x_ticks)
'''
斜体用$$包括, 空格需要转义
r"$\alpha$"  数学alpha符号
'''
#plt.yticks([-1, 0, 1, 2, 3], [r"$\alpha$", "bad", "normal", "good", "$very\ good$"])


ax = plt.gca() # get current axis
#ax.spines['right'].set_color("red")
'''
将坐标轴交叉点设置在(0, 0)
'''
'''
ax.spines['right'].set_color("none")
ax.spines['top'].set_color("none")
ax.xaxis.set_ticks_position("bottom")
ax.yaxis.set_ticks_position("left")
ax.spines['bottom'].set_position(('data', 0))
ax.spines['left'].set_position(('data', 0))
'''

ax.legend(loc="best")
'''
loc
    best
    upper right
'''
plt.show()


