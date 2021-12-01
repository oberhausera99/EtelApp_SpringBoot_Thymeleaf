# Tesztjegyzőkönyv-Bejelentkezés/Regisztráció

Az alábbi tesztdokumentum az Étel(etel-ib153i-5-2021) projekthez tartozó Bejelentkezés és Regisztráció funkcióihoz készült. Felelőse: Nagy Eliot 

## 1. Teszteljárások (TP)

### 1.1. Regisztráció értesítések
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02, TC-03, TC-04
- Leírás: regisztráció funkció helyes működésének ellenőrzése
    0. lépés: Nyissuk meg az alkalmazást, és kattintsunk a "Regisztráció" fülre"
    1. lépés: Adjunk meg helyes regisztrációs adatokat
    6. lépés: Nyomjuk meg az Regisztráció gombot 
    7. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: Értesítés sikeres regisztrációról!

### 1.2. Rendelés értesítések
- Azonosító: TP-02
- Tesztesetek: TC-01, TC-02
- Leírás: bejelentkezés funkció helyes működésének ellenőrzése
    0. lépés: Nyissuk meg az alkalmazást, és tegyünk be valamit a kosarunkba
    1. lépés: Nyomjunk rá a rendelés véglegesítése gombra
    2. lépés: Erősítsük meg a rendelést 
    3. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: Értesítés sikeres rendelésről!

## 2. Teszesetek (TC)

### 2.1. Regisztráció értesítő funkció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: regisztráció funkció tesztesetei
- Bemenet: Helyes adatok
- Művelet: nyomjuk meg a Regisztráció gombot 
- Elvárt kimenet: Értesítés sikeres regisztrációról!

#### 2.1.2. TC-02
- TP: TP-01
- Leírás: regisztráció funkció tesztesetei
- Bemenet: Helytelen adatok
- Művelet: nyomjuk meg a Regisztráció gombot 
- Elvárt kimenet: Értesítés sikertelen regisztrációról!


### 2.2. Rendelés értesítő funkció tesztesetei

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: rendelés funkció tesztelése
- Bemenet: Legalább 1 termék a kosárban
- Művelet: nyomjuk meg a Rendelés gombot 
- Elvárt kimenet: Értesítés sikeres rendelésről!

#### 2.2.1. TC-02
- TP: TP-02
- Leírás: rendelés funkció tesztelése
- Bemenet: üres kosár
- Művelet: nyomjuk meg a Rendelés gombot 
- Elvárt kimenet: Értesítés sikertelen rendelésről!


## 3. Tesztriportok (TR)

### 3.1. Regisztráció funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: A fentebb megadott adatokat beírtam
    2. lépés: a gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam (Sikeres regisztráció)
    

#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
    1. lépés: A fentebb megadott adatokat beírtam
    3. lépés: a gomb egyszeri megnyomás után inaktív lett
    4. lépés: helyes eredményt kaptam : Értesítés sikertelen regisztrációról

### 3.2. Rendelés funkció tesztriportjai

#### 3.2.1. TR-01 (TC-01)
- TP: TP-02
    1. lépés: Betettem a kosárba egy tonhalas pizzát
    2. lépés: a gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam : Értesítés sikeres rendelésről

#### 3.2.2. TR-02 (TC-02)
- TP: TP-02
    1. lépés: Nem raktam be semmit a kosárba
    2. lépés: a gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam : Értesítés sikertelen rendelésről


    