# EXPERIENŢA  DEBYE-SCHERRER  DE  DIFRACŢIE  A  ELECTRONILOR  PE  O  REŢEA POLICRISTALINĂ

### Documentația laboratorului se află în [fișierul pdf](https://github.com/Ghindea/Physics/blob/main/proiect_2_experienta_DS/Experienta_DEBYE-SCHERRER_de_difractie_a_electronilor_pe_o_retea_policristalina_(2020).pdf).

Prelucrarea datelor experimentale s-a efectuat în limbajul java conform indicațiilor (fun fact: pentru operația 1/sqrt(x) s-a folosit algoritmul de [fast inverse square root](https://github.com/Ghindea/Ghindea/blob/main/code_for_later/fast_inverse_sqrt.c) apărut în jocul [Quake III](https://en.wikipedia.org/wiki/Quake_III_Arena), iar interpretarea grafică a acestora s-a făcut în python cu ajutorul librăriei [matplotlib](https://matplotlib.org/).

### Programul rulează pe sistem Linux, pornind la comanda:
```
./lab1.sh
```
E foarte posibil ca scriptul să necesite permisiuni suplimentare ce îi pot fi atribuite cu
```
chmod a+x lab1.sh
```
Pentru a obtine un fisier .csv cu datele tabelare se poate sterge argumentul < tabel.csv > în instrucțiunea ```rm Prelucrare.class tabel.csv``` din fisierul [lab1.sh](https://github.com/Ghindea/Physics/blob/main/proiect_2_experienta_DS/lab1.sh).


no     |  U (kV)  |1/sqrt(U) (V^-1/2) | D1 (cm)  |D2 (cm) | λ1exp (pm)  | λ2exp (pm) |   λt (pm) |
-------|----------|-------------------|----------|--------|-------------|------------|-----------|
0      |     3.0  |          0.018257 |    2.85  |   5.00 |  22.483333  |  22.777778 | 22.389462 |
1      |     3.5  |          0.016903 |    2.70  |   4.60 |  21.300000  |  20.955556 | 20.728614 |
2      |     4.0  |          0.015811 |    2.50  |   4.25 |  19.722222  |  19.361111 | 19.389843 |
3      |     4.5  |          0.014907 |    2.45  |   4.10 |  19.327778  |  18.677778 | 18.280919 |
4      |     5.0  |          0.014142 |    2.35  |   3.90 |  18.538889  |  17.766667 | 17.342802 |

```
slope of D1  =  122.96354
d1_corrected =  2.6927230564403323e-10
Δd1 =  0.000000000056272

slope of D2  =  266.28733
d2_corrected =  1.2434191066477284e-10
Δd2 =  0.000000000001342
```
<img src="https://github.com/Ghindea/Physics/blob/main/proiect_2_experienta_DS/Figure_1.png">


### Disclaimer:
- pentru rulare e necesar să fie instalate și librăriile incluse în cod + comenzile de rulare pentru java si pyton =) 
- momentan sunt acceptate doar 5 seturi de măsurători

