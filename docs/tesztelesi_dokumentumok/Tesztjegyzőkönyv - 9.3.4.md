# Tesztjegyzőkönyv-Étel rendeléséhez tartozó üzleti logika

Az alábbi tesztdokumentum az Étel(etel-ib153i-5-2021) projekthez tartozó Étel rendeléséhez tartozó üzleti logika 9.3.4 funkcióihoz készült. Felelőse: Rózsa Kristóf

## 1. Teszteljárások (TP)

### 1.1. Rendelés kosárból kiválasztott étel nélkül
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02
- Leírás: Kosárba ételek hozzáadása utáni rendelés
    0. lépés: Nyissuk meg az alkalmazást
    1. lépés: Navigáljunk a 'kosár' pontba
    2. lépés: Kattintsunk a 'Rendelés véglegesítése' gombra 
    3. lépés: Ellenőrizzük az eredményt.
    Elvárt eredmény: A rendelés sikeres ha a kosárban van valami, sikertelen, ha nem.

### 1.2. Rendelések megnézése
- Azonosító: TP-02
- Tesztesetek: TC-01
- Leírás: Rendelés után megnézzük a rendelteket
    0. lépés: Nyissuk meg az alkalmazást
    1. lépés: hajtsuk végre az 1.1 -ben leírtakat(rendeljünk ételt)
    2. lépés: Navigáljunk a 'kosár' pontba
    3. lépés: Kattintsunk a 'Rendeléseim' gombra
    4. lépés: Ellenőrizzük az eredményt.
    Elvárt eredmény: Az eddigi rendeléseink kilistázódtak

### 1.3 Rendelések törlése adminnál
- Azonosító: TP-03
- Tesztesetek: TC-01
- Leírás: Beadott rendelések törlése
    0. lépés: Nyissuk meg az alkalmazást
    1. lépés: hajtsuk végre az 1.1 -ben leírtakat(rendeljünk ételt)
    2. lépés: Navigáljunk a 'kosár' pontba
    3. lépés: Kattintsunk a 'Rendelések' gombra
    4. lépés: Töröljünk egy rendelést
    5. lépés: Ellenőrizzük az eredményt.


## 2. Teszesetek (TC)

### 2.1. Rendelés kosárból tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: Kosárba ételek hozzáadása utáni rendelés tesztelése 
- Bemenet: Bejelentkezett user jogosultságú felhasználó, 2 'Pizza' és 1 'Sajtburger' -rel a kosárban
- Művelet: 'Rendelés véglegesítése' gombra való kattintás
- Elvárt kimenet: A rendelés sikeres, az adatok bekerülnek az adatbázisba

#### 2.1.1. TC-02
- TP: TP-01
- Leírás: Kosárba ételek hozzáadása utáni rendelés tesztelése berakott étel nélkül
- Bemenet: Bejelentkezett user jogosultságú felhasználó, étel nélkül a kosárban
- Művelet: 'Rendelés véglegesítése' gombra való kattintás
- Elvárt kimenet: A rendelés sikertelen

### 2.2. Rendelések megnézésének tesztesetei

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: Eddigi rendeléseink megnézésének tesztelése 
- Bemenet: Bejelentkezett user jogosultságú felhasználó, rendelt ételekkel
- Művelet: A kosár menüpontból kattintsunk a "Rendeléseim" gombra
- Elvárt kimenet: Kilistázódnak a rendeléseink

### 2.3 Rendelések törlése tesztesetei
#### 2.3.1 TC-01
- TP: TP-03
- Leírás: Rendelések törlése adminnál 
- Bemenet: Bejelentkezett admin jogosultságú felhasználó
- Művelet: A kosár menüpontból kattintsunk a "Rendelések" gombra, és töröljünk egy rendelést
- Elvárt kimenet: A rendelés sikeresen törlődik az adatbázisból


## 3. Tesztriportok (TR)

### 3.1. Rendelés kosárból tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: Bejelentkeztem user jogosultságú felhasználóval
    2. lépés: Beraktam a kosárba 2 'Pizza' és 1 'Sajtburger' -t
    3. lépés: Rákattinttam a "Rendelés véglegesítése" gombra
    3. lépés: Helyes eredményt kaptam: a rendelés sikeres volt, az adatok bekerültek az adatbázisba

#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
    1. lépés: Bejelentkeztem user jogosultságú felhasználóval
    2. lépés: Elnavigáltam a "kosár" pontba
    3. lépés: Rákattinttam a "Rendelés véglegesítése" gombra
    4. lépés: Helyes eredményt kaptam: a rendelés sikertelen volt, semmi nem került bele az adatbázisba


### 3.2. Rendelések megnézésének tesztriportjai

#### 3.2.1 TR-01 (TC-01)
- TP: TP-02
    1. lépés: Bejelentkeztem user jogosultságú felhasználóval
    2. lépés: Elnavigáltam a "kosár" pontba
    3. lépés: Rákattintottam a "Rendeléseim" gombra
    4. lépés: Helyes eredményt kaptam: megjelentek a rendelt ételek

### 3.3 Rendelések törlésének tesztriportjai

#### 3.3.1 TR-01 (TC-01)
- TP: TP-03
    1. lépés: Bejelentkeztem admin jogosultságú felhasználóval
    2. lépés: Elnavigáltam a "kosár" pontba
    3. lépés: Rákattintottam a "Rendelések" gombra
    4. lépés: Rákattintottam egy rendelésnél a törlésre
    5. lépés: Helyes eredményt kaptam: A rendelés törlődött az adatbázisból
