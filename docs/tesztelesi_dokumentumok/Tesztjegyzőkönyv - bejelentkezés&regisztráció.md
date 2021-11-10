# Tesztjegyzőkönyv-Bejelentkezés/Regisztráció

Az alábbi tesztdokumentum az Étel(etel-ib153i-5-2021) projekthez tartozó Bejelentkezés és Regisztráció funkcióihoz készült. Felelőse: Nagy Eliot 

## 1. Teszteljárások (TP)

### 1.1. Regisztráció 
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02, TC-03, TC-04
- Leírás: regisztráció funkció helyes működésének ellenőrzése
    0. lépés: Nyissuk meg az alkalmazást, és kattintsunk a "Regisztráció" fülre"
    1. lépés: Az Teljes név szövegbeviteli mezőbe írjunk be a teljes nevünket
    2. lépés: Az E-mail cím szövegbeviteli mezőbe írjunk be egy e-mail címet
    3. lépés: A Felhasználónév szövegbeviteli mezőbe írjunk be egy minimum 6 karakterből felhasználónevet címet
    4. lépés: A Jelszó szövegbeviteli mezőbe írjunk be egy minimum 8 karakterből álló jelszót
    5. lépés: A Jelszó ismét szövegbeviteli mezőbe írjuk be az előbb megadott jelszót
    6. lépés: Nyomjuk meg az Regisztráció gombot 
    7. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: Sikeres regisztráció!

### 1.2. Bejelentkezés
- Azonosító: TP-02
- Tesztesetek: TC-01, TC-02
- Leírás: bejelentkezés funkció helyes működésének ellenőrzése
    0. lépés: Nyissuk meg az alkalmazást, és kattintsunk a "Bejelentkezés" fülre
    1. lépés: A Felhasználó szövegbeviteli mezőbe írjunk be egy létező felhasználónevet
    2. lépés: A Jelszó szüvegbeviteli mezőbe írjuk be az előbb megadott felhasználónévhez tartozó jelszót 
    3. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: Sikeres bejelentkezés!

## 2. Teszesetek (TC)

### 2.1. Regisztráció funkció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: regisztráció funkció tesztesetei
- Bemenet: Teljes név: Bekre Pál, E-mail cím: bekrepal@freemail.hu, Felhasználónév: Pali123, Jelszó: asd12345, Jelszó ismét: asd12345
- Művelet: nyomjuk meg a Regisztráció gombot 
- Elvárt kimenet: az eredmény mező tartalma: Sikeres regisztráció!

#### 2.1.2. TC-02
- TP: TP-01
- Leírás: regisztráció funkció tesztesetei
- Bemenet: Teljes név: Riz Ottó, E-mail cím: bekrepal@freemail.hu, Felhasználónév: RizO123, Jelszó: asd1234, Jelszó ismét: asd1234
- Művelet: nyomjuk meg a Regisztráció gombot 
- Elvárt kimenet: az eredmény mező tartalma: Sikertelen regisztráció!(A jelszó nem elég hosszú)

#### 2.1.3. TC-03
- TP: TP-01
- Leírás: regisztráció funkció tesztesetei
- Bemenet: Teljes név: Riz Ottó, E-mail cím: bekrepal@freemail.hu, Felhasználónév: RizO, Jelszó: asd12345, Jelszó ismét: asd12345
- Művelet: nyomjuk meg a Regisztráció gombot 
- Elvárt kimenet: az eredmény mező tartalma: Sikertelen regisztráció!(A felhasználónév nem elég hosszú)

#### 2.1.4. TC-04
- TP: TP-01
- Leírás: regisztráció funkció tesztesetei
- Bemenet: Teljes név: Riz Ottó, E-mail cím: bekrepal@freemail.hu, Felhasználónév: RizO123, Jelszó: asd12345, Jelszó ismét: asd123456
- Művelet: nyomjuk meg a Regisztráció gombot 
- Elvárt kimenet: az eredmény mező tartalma: Sikertelen regisztráció!(A megadott jelszavak nem egyeznek)

### 2.2. Bejelentkezés funkció tesztesetei

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: bejelentkezés funkció tesztelése
- Bemenet: Felhasználónév: Pali123, jelszó: asd12345
- Művelet: nyomjuk meg a Bejelentkezés gombot 
- Elvárt kimenet: az eredmény mező tartalma: Sikeres bejelentkezés!

#### 2.2.1. TC-02
- TP: TP-02
- Leírás: bejelentkezés funkció tesztelése
- Bemenet: Felhasználónév: Pali123, jelszó: asd123456
- Művelet: nyomjuk meg a Bejelentkezés gombot 
- Elvárt kimenet: az eredmény mező tartalma: Sikertelen bejelentkezés!(Rossz felhasználónév/jelszó)

#### 2.2.1. TC-03
- TP: TP-02
- Leírás: bejelentkezés funkció tesztelése
- Bemenet: Felhasználónév: Pali1234, jelszó: asd12345
- Művelet: nyomjuk meg a Bejelentkezés gombot 
- Elvárt kimenet: az eredmény mező tartalma: Sikertelen bejelentkezés!(Rossz felhasználónév/jelszó)



## 3. Tesztriportok (TR)

### 3.1. Összeadás funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: A fentebb megadott adatokat beírtam
    2. lépés: a gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam (Sikeres regisztráció)
    

#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
    1. lépés: A fentebb megadott adatokat beírtam
    3. lépés: a gomb egyszeri megnyomás után inaktív lett
    4. lépés: helyes eredményt kaptam (HIBA - sikertelen regisztráció, a jelszó nem elég hosszú)

#### 3.1.3. TR-03 (TC-03)
- TP: TP-01
    1. lépés: A fentebb megadott adatokat beírtam
    3. lépés: a gomb egyszeri megnyomás után inaktív lett
    4. lépés: helyes eredményt kaptam (HIBA - sikertelen regisztráció, a felhasználónév nem elég hosszú)

#### 3.1.4. TR-04 (TC-04)
- TP: TP-01
    1. lépés: A fentebb megadott adatokat beírtam
    3. lépés: a gomb egyszeri megnyomás után inaktív lett
    4. lépés: helyes eredményt kaptam (HIBA - sikertelen regisztráció, a két jelszó nem egyezik)

### 3.2.Bejelentkezés funkció tesztriportjai

#### 3.2.1. TR-01 (TC-01)
- TP: TP-02
    1. lépés: A fentebb megadott adatokat beírtam
    2. lépés: a gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam (Sikeres bejelentkezés!)

#### 3.2.2. TR-02 (TC-02)
- TP: TP-02
    1. lépés: A fentebb megadott adatokat beírtam
    2. lépés: a gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam (HIBA - sikertelen bejelentkezés, Rossz felhasználónév/jelszó)

#### 3.2.2. TR-03 (TC-03)
- TP: TP-02
    1. lépés: A fentebb megadott adatokat beírtam
    2. lépés: a gomb egyszeri megnyomás után inaktív lett
    3. lépés: helyes eredményt kaptam (HIBA - sikertelen bejelentkezés, Rossz felhasználónév/jelszó)

    