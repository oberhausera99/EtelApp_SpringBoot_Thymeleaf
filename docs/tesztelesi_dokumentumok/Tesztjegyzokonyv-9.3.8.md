# Tesztjegyzőkönyv-Futárok kezeléséhez kapcsolódó üzleti logika (listázása, módosítása, létrehozása, törlése), GUI megvalósítása

Az alábbi tesztdokumentum az étel projekthez tartozó 9.3.8 Futárok kezeléséhez kapcsolódó üzleti logika (listázása, módosítása, létrehozása, törlése), GUI megvalósítása funkcióihoz készült. Felelőse: Nagy György


## 1. Teszteljárások (TP)

### 1.1. Futár hozzáadása funkció tesztelése
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02, TC-03
- Leírás: futár hozzáadásának tesztelése
    0. lépés: Menjünk a futár oldalra és tekerjünk le a hozzáadás részhez
    1. lépés: A 'név' szövegbeviteli mezőbe írjunk be a STRING1 szöveget
    2. lépés: A 'mióta' szövegbeviteli mezőbe írjunk be a NUMBER1 számot
    3. lépés: Nyomjuk meg a HOZZÁAD gombot 
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: az adat felkerült az adatbázisba

### 1.2. Futár törlése funkció tesztelése
- Azonosító: TP-02
- Tesztesetek: TC-01
- Leírás: futár törlésének tesztelése
    0. lépés: Menjünk a futár oldalra
    1. lépés: Válasszunk ki egy adatot a táblában
    2. lépés: Nyomjuk meg a TÖRLÉS gombot
    3. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: a rekord törlésre került
	
### 1.3. Futár módosítása funkció tesztelése
- Azonosító: TP-03
- Tesztesetek: TC-01, TC-02, TC-03
- Leírás: futár módosításának tesztelése
    0. lépés: Menjünk a futár oldalra
    1. lépés: Válasszunk ki egy adatot a táblában
    2. lépés: Nyomjuk meg a MÓDOSÍTÁS gombot
    3. lépés: A 'név' szövegbeviteli mezőbe írjunk be a STRING1 szöveget
    4. lépés: A 'mióta' szövegbeviteli mezőbe írjunk be a NUMBER1 számot
	5. lépés: Az "elérhető" szövegbeviteli mezőbe írjunk be a BOOLEAN értéket
	6. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: az adat módosításra került

## 2. Teszesetek (TC)

### 2.1. Hozzáadás funkció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: hozzáadás funkció tesztelése 
- Bemenet: STRING1 = 'Teszt' ; NUMBER1 = 2020
- Művelet: nyomjuk meg a HOZZÁAD gombot 
- Elvárt kimenet: a táblába felkerült az érték

#### 2.1.2. TC-02
- TP: TP-01
- Leírás: hozzáadás funkció tesztelése 
- Bemenet: STRING1 = 5 ; NUMBER1 = -5
- Művelet: nyomjuk meg az HOZZÁAD gombot 
- Elvárt kimenet: a táblába felkerült az érték, úgy hogy a második érték 2000-re módosul

#### 2.1.3. TC-03
- TP: TP-01
- Leírás: hozzáadás funkció tesztelése 
- Bemenet: STRING1 = 'Teszt' ; NUMBER1 = 'Teszt'
- Művelet: nyomjuk meg az HOZZÁAD gombot 
- Elvárt kimenet: NUMBER1 = HIBA 

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
- Bemenet: STRING1 = 'Teszt' ; NUMBER1 = 2018; BOOlEAN = false
- Művelet: nyomjuk meg a MÓDOSÍT gombot 
- Elvárt kimenet: a táblában módosult a kiválasztott érték

#### 2.3.2. TC-02
- TP: TP-03
- Leírás: módosítás funkció tesztelése 
- Bemenet: STRING1 = 25 ; NUMBER1 = -10 ; BOOLEAN = true
- Művelet: nyomjuk meg a MÓDOSÍT gombot 
- Elvárt kimenet: a táblában módosult a kiválasztott érték (nem sok értelme van, ezt javitani kell)

#### 2.3.3. TC-03
- TP: TP-03
- Leírás: módosítás funkció tesztelése 
- Bemenet: STRING1 = 'Teszt' ; NUMBER1 = 'teszt'; BOOLEAN = 'asd'
- Művelet: nyomjuk meg a MÓDOSÍT gombot 
- Elvárt kimenet: NUMBER1 = HIBA , BOOLEAN = HIBA 

## 3. Tesztriportok (TR)

### 3.1. Hozzáadás funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: 'Teszt'-t beírtam
    2. lépés: 2020-t beírtam
    3. lépés: a gomb egyszeri megnyomása után hozzáadta a futárt a táblához
    4. lépés: Helyes eredményt kaptam

#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
    1. lépés: 5-t beírtam
    2. lépés: -5-t beírtam
    3. lépés: a gomb egyszeri megnyomása után hozzáadta a futárt a táblához, úgy hogy módosult a második érték
    4. lépés: Helyes eredményt kaptam

#### 3.1.3. TR-03 (TC-03)
- TP: TP-01
    1. lépés: 'Teszt'-t beírtam
    2. lépés: 'Teszt'-t beírtam
    3. lépés: a gomb egyszeri megnyomása után nem adta hozzá a futárt a táblához
    4. lépés: Helyes eredményt kaptam (HIBA)

### 3.2. Törlés funkció tesztriportjai

#### 3.2.1. TR-01 (TC-01)
- TP: TP-02
	1. lépés: megnyomtam a 'Törlés gombot'
    2. lépés: a rekord törlésre került
    3. lépés: helyes eredményt kaptam

### 3.3. Módosítás funkció tesztriportjai

#### 3.3.1. TR-01 (TC-01)
- TP: TP-03
    1. lépés: 'Teszt'-t beírtam
    2. lépés: 2018-t beírtam
	3. lépés: falset-t beírtam
    4. lépés: a gomb egyszeri megnyomása után módosította a futárt a táblában
    5. lépés: Helyes eredményt kaptam

#### 3.3.2. TR-02 (TC-02)
- TP: TP-03
    1. lépés: 25-t beírtam
    2. lépés: -10-t beírtam
	3. lépés: true-t beírtam
    4. lépés: a gomb egyszeri megnyomása után módosította a futárt a táblában, úgy hogy a második értéket 2000-re állította
    5. lépés: Helyes eredményt kaptam

#### 3.3.3. TR-03 (TC-03)
- TP: TP-03
	1. lépés: 'Teszt'-t beírtam
    2. lépés: 'teszt'-t beírtam
	3. lépés: 'asd'-t beírtam
    4. lépés: a gomb egyszeri megnyomása után nem módosította a rekordot, mivel a 2. és 3. érték helytelen
    5. lépés: Helyes eredményt kaptam (HIBA)


    


    