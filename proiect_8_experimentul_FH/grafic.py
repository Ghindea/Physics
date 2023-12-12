import matplotlib.pyplot as plt
import numpy as np
import pandas
import math
import os


N =    [1,2,3,4,5]

Uv = [18.68666667, 35.80666667, 53.15833333, 71.765, 88.49333333]

x_model= np.linspace(min(N), max(N), 100)

coefs  = np.polyfit(N, Uv, deg=1)
poly   = np.poly1d(coefs)
slope = np.polyfit(N,Uv,1)[0]
# print("panta graficului n = f(Ω/4π) : ", slope)
# print("activitatea absoluta prin metoda Nului solid Λ : ", slope / 0.2)

# plt.plot(x_model, poly(x_model), label='ceva',)
plt.plot(N, Uv, 'ro') 

plt.ylabel('Umed (V)')
plt.xlabel('n')

plt.grid()
# plt.legend()

plt.show()