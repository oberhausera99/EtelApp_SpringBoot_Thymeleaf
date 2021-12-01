Az alábbi tesztdokumentum az `etel-ib153i-5-2021` projekthez tartozó
`9.3.6. Ételek, menük készítéséhez tartozó üzleti logika` funkcióihoz
készült. Felelőse: `Oberhauser Attila`

1. Teszteljárások (TP)
----------------------

### 1.1. Hozzáadás funkció tesztelése

-   Azonosító: TP-01
-   Tesztesetek: TC-01, TC-02
-   Leírás: összeadás funkció tesztelése
    0.  lépés: Nyissuk meg az alkalmazást, és jelentkezzünk be egy
        adminisztrátor jogosultságú fiókba. Navigáljunk a menühöz és
        kattintsunk a módosítani kívánt étel típusára
    1.  lépés: A `Név` szövegbeviteli mezőbe írjuk be a `TEXT1` szöveget
    2.  lépés: Az `Ár` szövegbeviteli mezőbe írjuk be a `NUMBER1` számot
    3.  lépés: Nyomjuk meg az `Submit` gombot
    4.  lépés: Ellenőrizzük az eredményt. Elvárt eredmény: A `TEXT1`
        nevű étel megjelenik a listán `NUMBER1` árral.

### 1.2. Módosítás funckió tesztelése

-   Azonosító: TP-02
-   Tesztesetek: TC-01- TC-02
-   Leírás: Módosítás funkció tesztelése
    0.  lépés: Nyissuk meg az alkalmazást, és jelentkezzünk be egy
        adminisztrátor jogosultságú fiókba. Navigáljunk a menühöz és
        kattintsunk a módosítani kívánt étel típusára
    1.  lépés: Nyomjuk meg az `Módosítás` gombot a módosítani kívánt
        étel neve mellett
    2.  lépés: A `Név` szövegbeviteli mezőbe írjuk be a `TEXT1` szöveget
    3.  lépés: Az `Ár` szövegbeviteli mezőbe írjuk be a `NUMBER1` számot
    4.  lépés: Nyomjuk meg a `Submit` gombot
    5.  lépés: Ellenőrizzük az eredményt. Elvárt eredmény: a módosítani
        kívánt étel attribútumai a 2. és 3. lépésben megadottakra
        módosultak.

    ### 1.3. Törlés funckió tesztelése

-   Azonosító: TP-03
-   Tesztesetek: TC-01
-   Leírás: Törlés funkció tesztelése
    0.  lépés: Nyissuk meg az alkalmazást, és jelentkezzünk be egy
        adminisztrátor jogosultságú fiókba. Navigáljunk a menühöz és
        kattintsunk a módosítani kívánt étel típusára
    1.  lépés: Nyomjuk meg az `Törlés` gombot a törölni kívánt étel neve
        mellett
    2.  lépés: Ellenőrizzük az eredményt. Elvárt eredmény: a törölt étel
        eltűnt a listából.

2. Tesztesetek (TC)
-------------------

### 2.1. Hozzáadás funkció tesztesetei

#### 2.1.1. TC-01

-   TP: TP-01
-   Leírás: hozzáadás funkció tesztelése
-   Bemenet: `TEXT1` = Hawaii pizza ; `NUMBER2` = 1300
-   Művelet: nyomjuk meg az `Submit` gombot
-   Elvárt kimenet: az ételek listája tartalmazza a következő értékeket:
    `Név` = Hawaii pizza, `Ár` = 1300.
    
#### 2.1.2. TC-02

-   TP: TP-02
-   Leírás: hozzáadás funkció tesztelése
-   Bemenet: `TEXT1` = Fank ; `NUMBER2` = -1
-   Művelet: nyomjuk meg az `Submit` gombot
-   Elvárt kimenet: az ételek listája tartalmazza a következő értékeket:
    Negatív árat adtunk meg, ezért egy hibaoldalra leszünk irányítva
    

### 2.2. Módosítás funkció tesztesetei

#### 2.2.1. TC-01

-   TP: TP-02
-   Leírás: Módosítás funkció tesztelése
-   Bemenet: `TEXT1` = Hawaii pizza, `NUMBER1` = 1301
-   Művelet: nyomjuk meg az `Submit` gombot
-   Elvárt kimenet: a Hawaii pizza nevű étel ára 1301-re módosult.

#### 2.2.2. TC-02

-   TP: TP-02
-   Leírás: hozzáadás funkció tesztelése
-   Bemenet: `TEXT1` = Fank ; `NUMBER2` = -1
-   Művelet: nyomjuk meg az `Submit` gombot
-   Elvárt kimenet: Helytelen értéket adtunk meg, így egy külön hibaoldalra lettünk átirányítva
    

### 2.3. Törlés funkció tesztesetei

#### 2.3.1. TC-01

-   TP: TP-03
-   Leírás: Törlés funkció tesztelése
-   Művelet: nyomjuk meg a Hawaii pizza nevű étel sorában lévő az
    `Törlés` gombot
-   Elvárt kimenet: a Hawaii pizza nevű étel többé nem található meg az
    ételek közt

3. Tesztriportok (TR)
-------------------

### 3.1. Hozzáadás funkció tesztriportjai

#### 3.1.1. TC-01

-   TP: TP-01
-   1. lépés: A névhez a 'Hawaii pizza' szöveget beírtam
-   2. lépés: Az árhoz 1300-at adtam meg
-   3. lépés: Megnyomam a Submit gombot
-   4. lépés: A listában megjelent a Hawaii pizza nevű étel 1300-as árral

#### 3.1.2. TC-02

-   TP: TP-01
-   1. lépés: A névhez a 'Fank' szöveget beírtam
-   2. lépés: Az árhoz -1-et adtam meg
-   3. lépés: Megnyomam a Submit gombot
-   4. lépés: Egy hibaoldalra lettem átirányítva, az új étel nem rögzült a listán

### 3.2. Módosítás funkció tesztriportjai

#### 3.2.1. TC-01

-   TP: TP-02
-   Leírás: a módosítás funkció tesztelése
-   1. lépés: Rányomtam a módosítás gombra a Hawaii pizza neve mellett
-   2. lépés: Az árat átírtam 1301-re
-   3. lépés: megnyomtam a Submit gombot
-   4. lépés: Az ételekhez visszatérve a Hawaii pizza ára 1301-re módosult	

#### 3.2.2. TC-02

-   TP: TP-02
-   Leírás: a módosítás funkció tesztelése
-   1. lépés: Rányomtam a módosítás gombra a Hawaii pizza neve mellett
-   2. lépés: Az árat átírtam -1-re
-   3. lépés: megnyomtam a Submit gombot
-   4. lépés: Egy hibaoldalra lettem átirányítva, az étel adatai nem módosultak


### 3.3. Törlés funkció tesztriportjai

#### 3.3.1. TC-01

-   TP: TP-03
-   Leírás: A törlés funkció tesztelése
-   1. lépés: Megnyomtam a Hawaii pizza neve mellett lévő törlés gombot
-   2. lépés: Az ételekhez visszatérve látszik, hogy a Hawaii pizza törlésre került


