from pylab import * 
import numpy as np

x = arange(0, 3, 1) 
y = np.array([1, 2, 3])

m,b = np.polyfit(x, y, 1) 

plot(x, y, 'yo', x, m*x+b, '--k') 
show()
