import matplotlib.pyplot as plt
import numpy as np
import pandas
import math
import os

from scipy.stats import linregress

U0 = [  0.69535,
        0.85141,
        1.2466,
        1.3236]
        # 1.1245]

V = [   5.190311419,
        5.494505495,
        6.880733945,
        7.407407407]
        # 8.196721311]
x_model= np.linspace(min(V), max(V), 100)

coefs  = np.polyfit(V, U0, deg=1)
poly   = np.poly1d(coefs)
slope = np.polyfit(V,U0,1)[0]
b = np.polyfit(V,U0,1)[1]
print("h / e = ", slope)
h = slope * 1.6 * pow(10,-33)
print("constanta lui Plank h = "+ str(h) + " Js")
vp = -1*b/slope
print("frecventa de prag = "+ str(vp) + " 10^14Hz" )
print("lungimea de unda de prag = " + str(3*pow(10,-6)/vp) + " m")
print("lucrul mecanic de extractie = " + str(h*vp * pow(10, 13)) + "J")
plt.plot(x_model, poly(x_model), label='ceva',)
plt.plot(V, U0, 'ro',)


plt.xlabel('V\n(10^14 Hz)')
plt.ylabel('U0\n(V)')

plt.grid()
plt.legend()

plt.show()