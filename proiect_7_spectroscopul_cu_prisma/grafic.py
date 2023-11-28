import matplotlib.pyplot as plt
import numpy as np
import pandas
import math
import os


unghi =    [296.4166667,
            297.2333333,
            297.5,
            298.1666667,
            299.15,
            300]

lamb = [623.4,
        579,
        546.1,
        496,
        435,
        404.7]

x_model= np.linspace(min(unghi), max(unghi), 100)

coefs  = np.polyfit(unghi, lamb, deg=1)
poly   = np.poly1d(coefs)
slope = np.polyfit(unghi,lamb,1)[0]
print("panta graficului n = f(Ω/4π) : ", slope)
print("activitatea absoluta prin metoda unghiului solid Λ : ", slope / 0.2)

plt.plot(x_model, poly(x_model), label='ceva',)
plt.plot(unghi, lamb, 'ro',) 

plt.ylabel('n\n(imp/s)')
plt.xlabel('Ω/4π')

plt.grid()
plt.legend()

plt.show()