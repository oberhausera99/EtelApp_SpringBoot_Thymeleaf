# Tesztjegyzőkönyv-Fuvarok kezeléséhez tartozó üzleti logika (listázása, módosítása, létrehozása, törlése), GUI megvalósítása

Az alábbi tesztdokumentum a étel projekthez tartozó 9.3.10 Fuvarok kezeléséhez tartozó üzleti logika (listázása, módosítása, létrehozása, törlése), GUI megvalósítása funkcióihoz készült. Felelőse: Nagy Dominik 


## 1. Teszteljárások (TP)

### 1.1. Fuvar hozzáadás funkció tesztelése 
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02, TC-03
- Leírás: Fuvar hozzáadásának tesztelése
  0. lépés: Menjünk a fuvar oldalra és tekerjünk le a hozzáadás részhez
  1. lépés: A 'Rendelés ID' szövegbeviteli mezőbe írjunk be a NUMBER1 számot
  2. lépés: A 'Futár ID' szövegbeviteli mezőbe írjunk be a NUMBER2 számot
  3. lépés: Nyomjuk meg a SUBMIT gombot
  4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: az adat felkerült az adatbázisba


### 1.2. Fuvar törlése funkció tesztelése
- Azonosító: TP-02
- Tesztesetek: TC-01
- Leírás: Fuvar törlésének tesztelése
  0. lépés: Menjünk a fuvar oldalra
  1. lépés: Válasszunk ki egy adatot a táblában
  2. lépés: Nyomjuk meg a TÖRLÉS gombot
  3. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: a rekord törlésre került

### 1.3. Fuvar módosítása funkció tesztelése
- Azonosító: TP-03
- Tesztesetek: TC-01
- Leírás: Fuvar módosításának tesztelése
  0. lépés: Menjünk a fuvar oldalra
  1. lépés: Válasszunk ki egy adatot a táblában
  2. lépés: Nyomjuk meg a MÓDOSÍTÁS gombot
  3. lépés: A 'Rendelés ID' szövegbeviteli mezőbe írjunk be a NUMBER1 számot
  4. lépés: A 'Futár ID' szövegbeviteli mezőbe írjunk be a NUMBER2 számot
  5. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: az adat módosításra került


## 2. Teszesetek (TC)

### 2.1. Hozzáadás funkció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: hozzáadás funkció tesztelése
- Bemenet: NUMBER1 = 52 ; NUMBER2 = 112
- Művelet: nyomjuk meg a SUBMIT gombot
- Elvárt kimenet: a táblába felkerült az érték


#### 2.1.2. TC-02
- TP: TP-01
- Leírás: hozzáadás funkció tesztelése
- Bemenet: NUMBER1 = 3000 ; NUMBER2 = 3000
- Művelet: nyomjuk meg az SUBMIT gombot
- Elvárt kimenet: HIBA, NUMBER1 és NUMBER2 külső kulcs

#### 2.1.3. TC-03
- TP: TP-01
- Leírás: hozzáadás funkció tesztelése
- Bemenet: NUMBER1 = 'valami1' ; NUMBER2 = 'valami2'
- Művelet: nyomjuk meg az SUBMIT gombot
- Elvárt kimenet: HIBA, nem megfelelő változó típus


### 2.2. Törlés funkció tesztesetei

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: törlés funkció tesztelése
- Művelet: nyomjuk meg az TÖRLÉS gombot
- Elvárt kimenet: a rekord törlésre került

### 2.3. Módosítás funkció tesztesetei

#### 2.3.1. TC-01
- TP: TP-03
- Leírás: módosítás funkció tesztelése
- Bemenet: NUMBER1 = 51 ; NUMBER2 = 116
- Művelet: nyomjuk meg a MÓDOSÍT gombot
- Elvárt kimenet: a táblában módosult a kiválasztott érték


## 3. Tesztriportok (TR)

### 3.1. Hozzáadás funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: 52-t beírtam
    2. lépés: 112-t beírtam 
    3. lépés: a SUBMIT gomb egyszeri megnyomás után az oldal lefrissült
    4. lépés: a táblába felkerült az érték
    

#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
    1. lépés: 3000-t beírtam
    2. lépés: 3000-t beírtam 
    3. lépés: Whitelabel Error Page (hibás input nincs lekezelve)

#### 3.1.3. TR-03 (TC-03)
- TP: TP-01
  1. lépés: 'valami1'-et beírtam
  2. lépés: 'valami2'-t beírtam
  3. lépés: Whitelabel Error Page (hibás input nincs lekezelve)


### 3.2. Törlés funkció tesztriportjai

#### 3.2.1. TR-01 (TC-01)
- TP: TP-02
    1. lépés: Kitörlendő sor megkeresése
    2. lépés: a sorban a TÖRLÉS gomb egyszeri megnyomás után az oldal lefrissült
    3. lépés: a rekord törlésre került


### 3.3. Módosítás funkció tesztriportjai

#### 3.3.1. TR-01 (TC-01)
- TP: TP-03
  1. lépés: Módosítandó sor megkeresése
  2. lépés: a sorban a MÓDOSÍTÁS gomb egyszeri megnyomás után átkerülünk a módosítás oldalra
  3. lépés: 51-et beírtam
  4. lépés: 116-ot beírtam
  5. Whitelabel Error Page (valami nem jó)

    