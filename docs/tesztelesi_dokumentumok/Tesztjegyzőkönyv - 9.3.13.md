# Tesztjegyzőkönyv-Fuvar idejének megjelenítése

Az alábbi tesztdokumentum az Étel(etel-ib153i-5-2021) projekthez tartozó Fuvar idejének megjelenítése 9.3.13 funkcióihoz készült. Felelőse: Rózsa Kristóf 

## 1. Teszteljárások (TP)

### 1.1. Fuvar várható idejének megnézése rendelés után
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02
- Leírás: Rendelés utáni várható megérkezés megnézése
    0. lépés: Jelentkezzünk be az applikációba user -ként
    1. lépés: Navigáljunk a /hamburgerek, /pizzak vagy /egyebek -hez
    2. lépés: Rendeljünk egy ételt
    3. lépés: Navigáljunk a kosárhoz, és kattintsunk a "Rendeléseim" gombra
    4. lépés: Ellenőrizzük az eredményt.
    Elvárt eredmény: A rendelést követően várhatóan 45 perc múlva érkezik a futár.


## 2. Teszesetek (TC)

### 2.1. 

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: Étel rendelés után 10 percel való érkezési idő megnézése 
- Bemenet: 10 perce rendelt étel
- Művelet: Rendeljünk egy ételt és várjunk 10 percet
- Elvárt kimenet: Az étel várható szállítási ideje 35 perc

#### 2.2.1. TC-02
- TP: TP-01
- Leírás: Étel rendelés után 1 órával való érkezési idő megnézése 
- Bemenet: 1 órája rendelt étel
- Művelet: Az Rendeljünk egy ételt és várjunk 1 órát percet
- Elvárt kimenet: Az étel várható szállítási ideje "hamarosan"


## 3. Tesztriportok (TR)

### 3.1. Eddigi biztonsági mentések kilistázásának tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    0. lépés: Bejelntkeztem az applikációba user -ként
    1. lépés: Elnavigáltam a /hamburgerek pontba
    2. lépés: Megrendeltem 1 -et a "Sajtburger" ételből
    3. lépés: Vártam 15 percet
    4. lépés: Helyes eredményt kaptam: A Sajtburger várható szállítási ideje 35 perc

#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
    0. lépés: Bejelntkeztem az applikációba user -ként
    1. lépés: Elnavigáltam a /pizzak pontba
    2. lépés: Megrendeltem 1 -et a "Sajtos Pizza" ételből
    3. lépés: Vártam 1 órát
    4. lépés: Helyes eredményt kaptam: A Sajtburger várható szállítási ideje "Hamarosan"

