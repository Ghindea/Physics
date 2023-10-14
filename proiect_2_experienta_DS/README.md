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

### Disclaimer:
- pentru rulare e necesar să fie instalate și librăriile incluse în cod + comenzile de rulare pentru java si pyton =) 
- momentan sunt acceptate doar 5 seturi de măsurători

