9.4.12. Biztonsági mentés tesztelése (TP, TC, TR)

# Tesztjegyzőkönyv-Biztonsági mentés

Az alábbi tesztdokumentum az Étel(etel-ib153i-5-2021) projekthez tartozó Biztonsági mentés megfelelő működéséhez készült. Felelőse: Nagy Eliot 

## 1. Teszteljárások (TP)

### 1.1. Biztonsági mentés 
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02
- Leírás: biztonsági mentés megfelelő működése
    0. lépés: Csatlakozzunk az adatbázishoz
    1. lépés: Listázzuk ki a tábláinkat
    2. lépés: Írjuk be a mentési parancsot \copy TÁBLANÉV to HELY AHOVA MENTENI SZERETNÉNK delimiter ';' csv header
    3. lépés: Nyomjuk meg az ENTER-t
    4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: Sikereresen létrejött a kiexportált CSV fájl a megfelelő helyen!

## 2. Tesztesetek (TC)

### 2.1. Biztonsági mentés tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: létező tábla exportálása
- Bemenet: egy létező tábla neve
- Művelet: hajtsuk végre az exportálást parancssor és a megfelelő parancs segítségével
- Elvárt kimenet: Sikeres exportálás! CMD-ben: COPY "EGY SZÁM, AMI A TÁBLA SORAINAK SZÁMÁT ADJA MEG"

#### 2.1.2. TC-02
- TP: TP-01
- Leírás: nem létező tábla exportálása
- Bemenet: egy, az adatbázisban nem létező tábla neve
- Művelet: hajtsuk végre az exportálást parancssor és a megfelelő parancs segítségével
- Elvárt kimenet: ERROR nincs ilyen tábla

## 3. Tesztriportok (TR)

### 3.1. Biztonsági mentés tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: Beírtam egy létező tábla nevét a parancsba, pl: etel
    2. lépés: helyes eredményt kaptam: Sikeres exportálás!
    

#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
    1. lépés: Beírtam egy nem létező táblanevet a parancsba, pl: autok
    2. lépés: helyes eredményt kaptam: Sikertelen exportálás! Error, nem létező táblanév



