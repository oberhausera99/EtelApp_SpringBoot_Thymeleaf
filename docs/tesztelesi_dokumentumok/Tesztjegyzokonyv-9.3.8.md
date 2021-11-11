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
- Bemenet: STRING1 = 5 ; NUMBER1 = 2019
- Művelet: nyomjuk meg az HOZZÁAD gombot 
- Elvárt kimenet: a táblába felkerült az érték (habár sok értelme nincs mivel a név nem értelmes, ezt később javítom)

#### 2.1.3. TC-03
- TP: TP-01
- Leírás: hozzáadás funkció tesztelése 
- Bemenet: STRING1 = 'Teszt' ; NUMBER1 = 'Teszt'
- Művelet: nyomjuk meg az HOZZÁAD gombot 
- Elvárt kimenet: NUMBER1 = HIBA (nem tudja a stringet számmá alakitani)

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
- Bemenet: STRING1 = 25 ; NUMBER1 = 2018; BOOLEAN = true
- Művelet: nyomjuk meg a MÓDOSÍT gombot 
- Elvárt kimenet: a táblában módosult a kiválasztott érték (nem sok értelme van, ezt javitani kell)

#### 2.3.3. TC-03
- TP: TP-03
- Leírás: módosítás funkció tesztelése 
- Bemenet: STRING1 = 'Teszt' ; NUMBER1 = 'teszt'; BOOLEAN = 'asd'
- Művelet: nyomjuk meg a MÓDOSÍT gombot 
- Elvárt kimenet: NUMBER1 = HIBA (nem tudja a stringet számmá alakitani), BOOLEAN = HIBA (nem tudja értelmezni a szöveget mint logikai érték)



    