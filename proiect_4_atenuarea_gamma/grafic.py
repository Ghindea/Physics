import matplotlib.pyplot as plt
import numpy as np
import pandas
import math
import os

from scipy.stats import linregress

XPb = [1,5,6,10,11]
lnAPb =    [8.20166019080868,
            7.93272102748195,
            7.71646080017636,
            7.39817409297047,
            7.25841215059531]

x_modelPb= np.linspace(min(XPb), max(XPb), 100)

coefsPb  = np.polyfit(XPb, lnAPb, deg=1)
polyPb   = np.poly1d(coefsPb)
slopePb = np.polyfit(XPb,lnAPb,1)[0]
print("coeficientul de atenuare μPb = ", -1*slopePb)

plt.plot(x_modelPb, polyPb(x_modelPb), label='Pb',)
plt.plot(XPb, lnAPb, 'ro',)


XCu = [1,5,6,8,11]
lnACu =    [8.24170315972982,
            8.07309119969315,
            7.97865372908273,
            7.92117272158701,
            7.74066440191724]

x_modelCu= np.linspace(min(XCu), max(XCu), 100)

coefsCu  = np.polyfit(XCu, lnACu, deg=1)
polyCu   = np.poly1d(coefsCu)
slopeCu = np.polyfit(XCu,lnACu,1)[0]
print("coeficientul de atenuare μCu = ", -1*slopeCu)

plt.plot(x_modelCu, polyCu(x_modelCu), label='Cu',)
plt.plot(XCu, lnACu, 'ro',)



plt.xlabel('x\n(mm)')
plt.ylabel('lnI\n( particule/cm^2s )')

plt.grid()
plt.legend()

plt.show()