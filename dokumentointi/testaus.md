# Testausdokumentti

Sovelluksen testaukseen on käytetty JUnit testejä sekä manuaalista testausta.

## Yksikkö- ja integraatiotestaus

### sovelluslogiikka

Sovelluksen testiluokat ovat seuraavat:

[BoardTest](https://github.com/synesteesia/ot-harjoitustyo/blob/master/Soundboard/src/test/java/soundboard/logic/BoardTest.java), [SoundPadTest](https://github.com/synesteesia/ot-harjoitustyo/blob/master/Soundboard/src/test/java/soundboard/logic/SoundPadTest.java) ja [BoardIOTest](https://github.com/synesteesia/ot-harjoitustyo/blob/master/Soundboard/src/test/java/soundboard/logic/BoardIOTest.java).


### Testauskattavuus

Sovelluksen rivikattavuus on 89% ja haarautumakattavuus 83%. Testeistä on jätetty pois käyttöliittymän rakentavat luokat.

<img src="https://github.com/synesteesia/ot-harjoitustyo/blob/master/dokumentointi/Kuvat/Jacoco.png">

Testaamatta jäi jonkin verran ThreadPad luokan toiminnallisuutta.

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Sovellusta on testattu manuaalisesti kun se on asennettu [käyttöohjeen](https://github.com/synesteesia/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md) kuvaamalla tavalla kahdella Linux koneella. Testausta ei ole tehty siis tilanteessa, jossa asennus on tehty virheellisesti.

### Toiminnallisuudet

Kaikki [määrittelydokumentin](https://github.com/synesteesia/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md) ja käyttöohjeen listaamat toiminnallisuudet on käyty läpi. Kaikkien toiminnallisuuksien yhteydessä on syötekentät yritetty täyttää myös virheellisillä tiedostojen nimillä tai väärän tyyppisillä tiedostoilla.

## Sovellukseen jääneet laatuongelmat

Testiluokan SoundPadTest testi playSoundErrorWorks() tulostaa "java.io.IOException: File Not Found" kahdesti.
