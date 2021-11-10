# Tesztjegyzőkönyv-Kapcsolatfelvételi űrlap biztosítása új ügyfelek számára (üzleti logika és GUI)

Az alábbi tesztdokumentum az étel projekthez tartozó 9.3.14 kapcsolatfelvételi űrlap biztosítása új ügyfelek számára (üzleti logika és GUI) funkcióihoz készült. Felelőse: Nagy György


## 1. Teszteljárások (TP)


### 1.1. Vélemény hozzáadása 
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02, TC-03
- Leírás: vélemény hozzáadásának tesztelése
    0. lépés: Jelentkezzünk be USER felhasználóval
    1. lépés: Menjünk a kapcsolat oldalra
    2. lépés: Irjunk be a szövegdobozba egy STRING1 szöveget
    3. lépés: Adjunk meg egy értéket a csúszka segítségével
	4. lépés: Nyomjuk meg az ELKÜLDÉS gombot a véglegesítéshez
	5. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: a vélemény és az értékelés felkerült a kapcsolat oldalra
	
### 1.2. Vélemény törlése
- Azonosító: TP-02
- Tesztesetek: TC-01, TC-02, TC-03
- Leírás: vélemény törlésének tesztelése
    0. lépés: Jelentkezzünk be USER felhasználóval
    1. lépés: Menjünk a kapcsolat oldalra
    2. lépés: Válasszunk ki egy véleményt majd kattintsuk a TÖRLÉS gombra
    3. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: az vélemény törlésre került megfelelő jogusultság által

## 2. Teszesetek (TC)

### 2.1. Hozzáadás funció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: hozzáadás funkció tesztelése 
- Bemenet: USER = 'Teszt' ; STRING1 = 'tetszik az oldal'
- Művelet: Húzzunk be egy értéket a csúszkával, majd nyomjuk meg az ELKÜLDÉS gombot 
- Elvárt kimenet: a vélemény és az értékelés felkerült a kapcsolat oldalra (kapunk egy visszajelzés oldalt előtte)

#### 2.1.2. TC-02
- TP: TP-01
- Leírás: hozzáadás funkció tesztelése 
- Bemenet: USER = '' ; STRING1 = 'tetszik az oldal'
- Elvárt kimenet: nem tudunk véleményt irni mivel nem vagyunk bejelentkezve


#### 2.1.3. TC-03
- TP: TP-01
- Leírás: hozzáadás funkció tesztelése 
- Bemenet: USER = 'admin' ; STRING1 = 'tetszik az oldal'
- Elvárt kimenet: nem tudunk véleményt irni mivel adminnak nincs rá szüksége, hogy véleményt írjon

### 2.2. Törlés funkció tesztesetei

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: törlés funkció tesztelése
- Bemenet: USER = 'Teszt'
- Művelet: válasszunk ki egy véleményt, majd nyomjuk meg az TÖRLÉS gombot 
- Elvárt kimenet: nincs megfelelő jogosultság, nem történik semmi

#### 2.2.2. TC-02
- TP: TP-02
- Leírás: törlés funkció tesztelése
- Bemenet: USER = ''
- Művelet: válasszunk ki egy véleményt, majd nyomjuk meg az TÖRLÉS gombot 
- Elvárt kimenet: nincs megfelelő jogosultság, nem történik semmi

#### 2.2.3. TC-03
- TP: TP-02
- Leírás: törlés funkció tesztelése
- Bemenet: USER = 'admin'
- Művelet: válasszunk ki egy véleményt, majd nyomjuk meg az TÖRLÉS gombot 
- Elvárt kimenet: a kiválasztott rekord törlésre került






    