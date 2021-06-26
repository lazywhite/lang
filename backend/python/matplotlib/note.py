import matplotlib.font_manager as fm
import matplotlib.pyplot as plt
import matplotlib.ticker as tick
'''
import matplotlib.pyplot error
yum -y install mesa-libGL
'''

plt.switch_backend('agg') # no xwindow required
wqy = fm.FontProperties(fname="/usr/share/fonts/wqy-zenhei/wqy-zenhei.ttc")# 中文字体

fig, ax = plt.subplots(nrows=1, ncols=1)
ax.get_xaxis().get_major_formatter().set_scientific(False) # 避免简写为科学记数法
ax.get_yaxis().get_major_formatter().set_scientific(False) 
ax.plot([0, 1, 2], [10, 20, 30], label="你好")
ax.plot([0, 1, 2], [10000, 20000, 30000000], label="line2")
'''
ax.plot()折线图
ax.bar()直方图
ax.scatter()散点图
'''

def y_fmt(tick_val, pos):
    if tick_val > 1000000:
        val = int(tick_val/ 1000000)
        return '{:d} M'.format(val)
    if tick_val > 1000:
        val = int(tick_val/ 1000)
        return '{:d} K'.format(val)
    return tick_val

plt.xlabel('横轴',fontproperties=wqy)
plt.ylabel('纵轴',fontproperties=wqy)
plt.title('线图',fontproperties=wqy)
plt.xticks( (0,1, 2),('11111','222222', '33333') ,rotation=60, fontproperties=wqy) # x值映射， rotation默认逆时针旋转，可以为负值
ax.legend(prop=wqy) # 搭配line label使用
ax.yaxis.set_major_formatter(tick.FuncFormatter(y_fmt))
fig.savefig("/mnt/a.png")
plt.close(fig)
