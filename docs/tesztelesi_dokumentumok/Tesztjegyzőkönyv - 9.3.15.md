# Tesztjegyzőkönyv-Biztonsági mentések

Az alábbi tesztdokumentum az Étel(etel-ib153i-5-2021) projekthez tartozó Biztonsági mentések automatikus létrehozása 9.3.15 funkcióihoz készült. Felelőse: Rózsa Kristóf 

## 1. Teszteljárások (TP)

### 1.1. Eddigi biztonsági mentések kilistázása
- Azonosító: TP-01
- Tesztesetek: TC-01
- Leírás: Az eddig készített biztonsági mentések megjelenítése
    0. lépés: Nyissunk meg egy terminált, és jelentkezzünk be a herokuval
    1. lépés: Írjuk be a 'heroku pg:backups -a etel-ib153i-5-2021' parancsot
    2. lépés: Ellenőrizzük az eredményt.
    Elvárt eredmény: Az eddigi biztonsági mentéseink kiíratásra kerülnek

### 1.2. Biztonsági mentés visszaállítása
- Azonosító: TP-02
- Tesztesetek: TC-01
- Leírás: Az egyik biztonsági mentést visszaállítjuk
    0. lépés: Nyissunk meg egy terminált, és jelentkezzünk be a herokuval
    1. lépés: Írjuk be a 'heroku pg:backups:restore <BACKUP> -a etel-ib153i-5-2021' parancsot
    2. lépés: Ellenőrizzük az eredményt.
    Elvárt eredmény: A kivánt biztonsági mentés helyreállításra került

## 2. Teszesetek (TC)

### 2.1. Eddigi biztonsági mentések kilistázásának tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: Fuvar végpont elérésének tesztelése 
- Bemenet: Nincs
- Művelet: Beírjuk a 'heroku pg:backups -a etel-ib153i-5-2021' parancsot a terminálba
- Elvárt kimenet: Az eddigi biztonsági mentések kiíródnak

### 2.2 Biztonsági mentés visszaállításának tesztesetei

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: Biztonsági mentés visszaállításának tesztelése 
- Bemenet: 'a003' mentés
- Művelet: Beírjuk a 'heroku pg:backups:restore a003 -a etel-ib153i-5-2021' parancsot a terminálba
- Elvárt kimenet: Az a003 mentés helyreállítódik


## 3. Tesztriportok (TR)

### 3.1. Eddigi biztonsági mentések kilistázásának tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: Megnyitottam egy terminált
    2. lépés: beírtam a 'heroku pg:backups -a etel-ib153i-5-2021' parancsot
    3. lépés: Helyes eredményt kaptam: az eddigi mentések kiíródtak.

### 3.2. Eddigi biztonsági mentések kilistázásának tesztriportjai

#### 3.2.1. TR-01 (TC-01)
- TP: TP-02
    1. lépés: Megnyitottam egy terminált
    2. lépés: beírtam a 'heroku pg:backups:restore a003 -a etel-ib153i-5-2021' parancsot
    3. lépés: Helyes eredményt kaptam: a mentés helyreállítódott.
