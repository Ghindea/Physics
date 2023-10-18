import matplotlib.pyplot as plt
import numpy as np
import pandas
import math
import os

from scipy.stats import linregress

os.system("clear")
csvFile = pandas.read_csv('tabel.csv')
print(csvFile)

sqrtU = csvFile.iloc[:, 1]
D1    = csvFile.iloc[:, 2]
D2    = csvFile.iloc[:, 3]

x_model= np.linspace(min(sqrtU), max(sqrtU), 100)
e = 1.602 * pow(10, -19)
m = 9.109 * pow(10, -31)
h = 6.625 * pow(10, -34)
L = 13.5

d1= 2.13  * pow(10, -10)
d2= 1.23  * pow(10, -10)
zme = 2 * m * e

#plot fit for D1
coefs  = np.polyfit(sqrtU, D1, deg=1)
poly   = np.poly1d(coefs)

plt.plot(x_model, poly(x_model), label='D1',)
plt.plot(sqrtU, D1, 'ro',)

slope = np.polyfit(sqrtU,D1,1)[0]
d1_corrected = (2 * h * L) / (math.sqrt(zme) * slope)

print('\n')
print("slope of D1  = ", '%.5f' % slope)
print("d1_corrected = ", d1_corrected)
print("Δd1 = ", '%.15f' % abs(d1 - d1_corrected))
print()
#plot fit for D2
coefs  = np.polyfit(sqrtU, D2, deg=1)
poly   = np.poly1d(coefs)

plt.plot(x_model, poly(x_model), label='D2',)
plt.plot(sqrtU, D2, 'ro',)

slope = np.polyfit(sqrtU,D2,1)[0]
d2_corrected = (2 * h * L) / (math.sqrt(zme) * slope)

print("slope of D2  = ", '%.5f' % slope)
print("d2_corrected = ", d2_corrected)
print("Δd2 = ", '%.15f' % abs(d2 - d2_corrected))
print('\n')

#plot dots
plt.scatter(sqrtU, D1)
plt.scatter(sqrtU, D2)

#graph extra
plt.xlabel('1/sqrt(U)\n(V^-1/2)')
plt.ylabel('Diametru\n(cm)')

plt.grid()
plt.legend()

plt.show()