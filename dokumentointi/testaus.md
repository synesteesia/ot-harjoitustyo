# Testausdokumentti

Ohjelmaa on testattu sekä automatisoiduin yksikkö- ja integraatiotestein JUnitilla sekä manuaalisesti tapahtunein järjestelmätason testein.

## Yksikkö- ja integraatiotestaus

### sovelluslogiikka

Automatisoitujen testien ytimen moudostavat sovelluslogiikkaa, eli pakkauksen soundboard.logic luokkia testaavat integraatiotestit [BoardTest](https://github.com/synesteesia/ot-harjoitustyo/blob/master/Soundboard/src/test/java/soundboard/logic/BoardTest.java), [SoundPadTest](https://github.com/synesteesia/ot-harjoitustyo/blob/master/Soundboard/src/test/java/soundboard/logic/SoundPadTest.java) ja [BoardIO](https://github.com/synesteesia/ot-harjoitustyo/blob/master/Soundboard/src/test/java/soundboard/logic/BoardIOTest.java).

Integraatiotestit....

### Testauskattavuus

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 89% ja haarautumakattavuus 83%

<img src="https://github.com/synesteesia/ot-harjoitustyo/blob/master/dokumentointi/Kuvat/Jacoco.png">

Testaamatta jäi jonkin verran ThreadPad luokan toiminnallisuutta.

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Sovellus on haettu ja sitä on testattu [käyttöohjeen](https://github.com/synesteesia/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md) kuvaamalla tavalla usealla Linux koneella siten, että sovelluksen käynnistyshakemistossa on ollut käyttöohjeen kuvauksen mukaiset kansiot ja tiedostot.

### Toiminnallisuudet

Kaikki [määrittelydokumentin](https://github.com/synesteesia/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md) ja käyttöohjeen listaamat toiminnallisuudet on käyty läpi. Kaikkien toiminnallisuuksien yhteydessä on syötekentät yritetty täyttää myös virheellisillä arvoilla kuten tiedostojen nimillä joita ei ole olemassa tai väärän tyyppisillä tiedostoilla.

## Sovellukseen jääneet laatuongelmat

Testiluokan SoundPadTest testi playSoundErrorWorks() tulostaa "java.io.IOException: File Not Found" kahdesti.
