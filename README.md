# Soundboard

Sovelluksen avulla käyttäjä voi soittaa haluamiaan .wav äänitiedostoja klikkaamalla nappeja soundboardissa.

## Dokumentaatio

[kayttoohje.md](https://github.com/synesteesia/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)

[vaatimusmaarittely.md](https://github.com/synesteesia/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[tuntikirjanpito.md](https://github.com/synesteesia/ot-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)

[arkkitehtuuri.md](https://github.com/synesteesia/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)


## Releaset

[Viikko 5](https://github.com/synesteesia/ot-harjoitustyo/releases/tag/Viikko5)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _Soundboard-1.0-SNAPSHOT.jar_
Tiedosto toimii joko siirtämällä se hakemistoon _Soundboard_ tai purkamalla sen suoritushakemistoon _Soundboard_ hakemistosta löytyvän _soundBoardFiles.zip_ tiedoston.


### Checkstyle

Tiedoston [checkstyle.xml](https://github.com/synesteesia/ot-harjoitustyo/blob/master/Soundboard/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
