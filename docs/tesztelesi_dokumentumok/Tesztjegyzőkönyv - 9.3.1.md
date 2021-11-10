# Tesztjegyzőkönyv-Jogosultsági szintek

Az alábbi tesztdokumentum az Étel(etel-ib153i-5-2021) projekthez tartozó jogosultsági szintek 9.3.1 funkcióihoz készült. Felelőse: Rózsa Kristóf 

## 1. Teszteljárások (TP)

### 1.1. Futár végpont elérése
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02
- Leírás: Futár végpont elérésének tesztelése
    0. lépés: Nyissuk meg az alkalmazást
    1. lépés: Nyissuk meg a /futár végpontot
    2. lépés: Ellenőrizzük az eredményt.
    Elvárt eredmény:
    User esetén: redirect egy másik oldalra
    Admin esetén: végpont rendesen elérhetővé válik

### 1.2. Fuvar végpont elérése
- Azonosító: TP-02
- Tesztesetek: TC-01, TC-02
- Leírás: Fuvar végpont elérésének tesztelése
    0. lépés: Nyissuk meg az alkalmazást
    1. lépés: Nyissuk meg a /fuvar végpontot
    2. lépés: Ellenőrizzük az eredményt.
    Elvárt eredmény:
    User esetén: redirect egy másik oldalra
    Admin esetén: végpont rendesen elérhetővé válik

### 1.3. Rendelésnél az étel törlése/módosításának elérhetősége
- Azonosító: TP-03
- Tesztesetek: TC-01, TC-02
- Leírás: Étel törlés/módosításának elérésének tesztelése
    0. lépés: Nyissuk meg az alkalmazást
    1. lépés: Nyissuk meg a /pizzak, /hamburgerek vagy /egyebek végpontokat
    2. lépés: Ellenőrizzük az eredményt.
    Elvárt eredmény:
    User esetén: Törlés/módosítás nem elérhető
    Admin esetén: Törlés/módosítás elérhető

## 2. Teszesetek (TC)

### 2.1. Futár végpont elérése funkció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: Futár végpont elérésének tesztelése 
- Bemenet: Bejelentkezett admin jogosultságú felhasználó
- Művelet: Érjük el a /futarok végpontot
- Elvárt kimenet: A futarok végpont megfelelően megjelenik

#### 2.1.2. TC-02
- TP: TP-01
- Leírás: Futár végpont elérésének tesztelése 
- Bemenet: Bejelentkezett user jogosultságú felhasználó
- Művelet: Érjük el a /futarok végpontot
- Elvárt kimenet: Az oldal átirányít minket a végpontról

### 2.2. Fuvar végpont elérése funkció tesztesetei

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: Fuvar végpont elérésének tesztelése 
- Bemenet: Bejelentkezett admin jogosultságú felhasználó
- Művelet: Érjük el a /fuvarok végpontot
- Elvárt kimenet: A futarok végpont megfelelően megjelenik

#### 2.2.2. TC-02
- TP: TP-02
- Leírás: Fuvar végpont elérésének tesztelése 
- Bemenet: Bejelentkezett user jogosultságú felhasználó
- Művelet: Érjük el a /fuvarok végpontot
- Elvárt kimenet: Az oldal átirányít minket a végpontról


### 2.3. Rendelésnél az étel törlése/módosításának elérhetőségének tesztesetei

#### 2.3.1. TC-01
- TP: TP-03
- Leírás: Étel törlés/módosítás elérhetőségének tesztelése 
- Bemenet: Bejelentkezett admin jogosultságú felhasználó
- Művelet: Érjük el az /hamburgerek, /oldal vagy /egyebek végpontot
- Elvárt kimenet: Az ételnél megjelenik a törlés/módosítás opció, majd az oldal alatt az étel hozzáadása opció.

#### 2.3.2. TC-02
- TP: TP-03
- Leírás: Étel törlés/módosítás elérhetőségének tesztelése
- Bemenet: Bejelentkezett user jogosultságú felhasználó
- Művelet: Érjük el az /hamburgerek, /oldal vagy /egyebek végpontot
- Elvárt kimenet: Az ételnél nem jelenik meg se a törlés, módosítás, vagy a hozzáadás opció.


## 3. Tesztriportok (TR)

### 3.1. Futár végpont elérésének tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: Bejelentkeztem admin jogosultságú felhasználóval
    2. lépés: Megpróbáltam elérni a /futarok végpontot
    3. lépés: Helyes eredményt kaptam: a végpontot elértem

#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
    1. lépés: Bejelentkeztem user jogosultságú felhasználóval
    2. lépés: Megpróbáltam elérni a /futarok végpontot
    3. lépés: Helyes eredményt kaptam: a szerver átírányított az /index -re.


### 3.2. Fuvar végpont elérésének tesztriportjai

#### 3.2.1 TR-01 (TC-01)
- TP: TP-02
    1. lépés: Bejelentkeztem admin jogosultságú felhasználóval
    2. lépés: Megpróbáltam elérni a /fuvarok végpontot
    3. lépés: Helyes eredményt kaptam: a végpontot elértem

#### 3.2.2. TR-02 (TC-02)
- TP: TP-02
    1. lépés: Bejelentkeztem user jogosultságú felhasználóval
    2. lépés: Megpróbáltam elérni a /fuvarok végpontot
    3. lépés: Helyes eredményt kaptam: a szerver átírányított az /index -re.


### 3.3. Rendelésnél az étel törlése/módosításának elérhetőségének tesztriportjai

#### 3.2.1 TR-01 (TC-01)
- TP: TP-03
    1. lépés: Bejelentkeztem admin jogosultságú felhasználóval
    2. lépés: Elértem a /hamburger végpontot
    3. lépés: Helyes eredményt kaptam: az ételt tudom törölni, módosítáani és hozzáadni

#### 3.2.2. TR-02 (TC-02)
- TP: TP-03
    1. lépés: Bejelentkeztem user jogosultságú felhasználóval
    2. lépés: Megpróbáltam elérni a /fuvarok végpontot
    3. lépés: Helyes eredményt kaptam: az ételt nem tudom törölni, módosítani vagy hozzáadni


