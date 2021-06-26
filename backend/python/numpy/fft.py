import matplotlib.pyplot as plt
from numpy import *
from numpy.fft import fft

x = linspace(-pi, pi, 100)
#y = sin(x) + cos(2 * x)
y = sin(x) 
plt.plot(x, y)
plt.show()

plt.clf()
