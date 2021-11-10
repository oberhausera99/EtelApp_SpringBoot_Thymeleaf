# Tesztjegyzőkönyv-Rendelés értesítés

Az alábbi tesztdokumentum az Étel(etel-ib153i-5-2021) projekthez tartozó Értesítés sikeres rendelésről 9.3.12 funkcióihoz készült. Felelőse: Nagy Eliot 

``` 
A tesztelési dokumentáció áttekinthetőségének érdekében egy jegyzőkönyv egy adott témához tartozó funkciókat tartalmazza 
(pl. vektorműveletek) és ne az adott projekttaghoz tartozó összes funkció tesztelését belesűrítve egy fájlba.
``` 

## 1. Teszteljárások (TP)

### 1.1. Rendelés a kosárból 
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02
- Leírás: rendelés a kosárból funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást, és adjunk hozzá valamilyen terméket a kosárhoz
    1. lépés: Kattintsunk a kosár fülre
    2. lépés: Nyomjuk meg a Rendelés véglegesítése gombot
    3. lépés: Erősítsük meg a rendelést
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: Sikereres rendelés!

## 2. Teszesetek (TC)

### 2.1. Rendelés a kosárból funkció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: rendelés a kosárból funkció tesztelése 
- Bemenet: Több termék a kosárban
- Művelet: nyomjuk meg a Rendelés véglegesítése gombot majd erősítsük meg a rendelést
- Elvárt kimenet: az eredmény mező tartalma: Sikeres rendelés!

#### 2.1.2. TC-02
- TP: TP-01
- Leírás: rendelés a kosárból funkció tesztelése 
- Bemenet: Egy termék a kosárban
- Művelet: nyomjuk meg a Rendelés véglegesítése gombot majd erősítsük meg a rendelést
- Elvárt kimenet: az eredmény mező tartalma: Sikeres rendelés!

#### 2.1.3. TC-03
- TP: TP-01
- Leírás: rendelés a kosárból funkció tesztelése 
- Bemenet: 0 termék a kosárban
- Művelet: nyomjuk meg a Rendelés véglegesítése gombot majd erősítsük meg a rendelést
- Elvárt kimenet: az eredmény mező tartalma: HIBA - üres a kosár, sikertelen rendelés


## 3. Tesztriportok (TR)

### 3.1. Rendelés a kosárból funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: 1 db Sajtburgert hozzáadtam a kosárhoz
    2. lépés: a rendelés gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam: Sikeres rendelés!
    

#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
    1. lépés: 1 db Sajtburgert hozzáadtam a kosárhoz
    2. lépés: 1 db Mexikói pizzát hozzáadtam a kosárhoz
    3. lépés: 1 db Csirkesalátát hozzáadtam a kosárhoz
    2. lépés: a rendelés gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam: Sikeres rendelés!

#### 3.1.3. TR-03 (TC-03)
- TP: TP-01
    1. lépés: nem adtam hozzá semmit a kosárhoz
    2. lépés: a rendelés gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam: HIBA - Sikertelen rendelés, a kosár üres!


    