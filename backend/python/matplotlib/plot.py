# -*- coding: utf-8 -*-
import numpy as np
import matplotlib.pyplot as plt

#x = np.logspace(1, 2, num=50,base=10, dtype=np.int )
x = np.linspace(0, 2 * np.pi, 100)

y = np.sin(x)
plt.figure()
plt.plot(x, y, color="red", linewidth=.4, linestyle='--')
plt.show()
