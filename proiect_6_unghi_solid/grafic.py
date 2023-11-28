import matplotlib.pyplot as plt
import numpy as np
import pandas
import math
import os


OmegaPI =   [1.143782139,
            0.11263013,
            0.038107151,
            0.019210608]
n = [371.5116667,
    75.23666667,
    31.25055556,
    18.31166667]

x_model= np.linspace(min(OmegaPI), max(OmegaPI), 100)

coefs  = np.polyfit(OmegaPI, n, deg=1)
poly   = np.poly1d(coefs)
slope = np.polyfit(OmegaPI,n,1)[0]
print("panta graficului n = f(Ω/4π) : ", slope)
print("activitatea absoluta prin metoda unghiului solid Λ : ", slope / 0.2)

plt.plot(x_model, poly(x_model), label='ceva',)
plt.plot(OmegaPI, n, 'ro',) 

plt.ylabel('n\n(imp/s)')
plt.xlabel('Ω/4π')

plt.grid()
plt.legend()

plt.show()