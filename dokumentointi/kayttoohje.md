# Käyttöohje

Lataa tiedosto [Soundboard.jar](https://github.com/synesteesia/ot-harjoitustyo/releases/download/Viikko6/Soundboard.jar)

Lataa tiedosto [soundBoardFiles.zip](https://github.com/synesteesia/ot-harjoitustyo/releases/download/Viikko6/soundBoardFiles.zip)

## Konfigurointi

Ohjelma olettaa, että sen käynnistyshakemistossa on kaikki _soundBoardFiles.zip_ sisältämät kansiot, jotka sisältävät .wav tiedostoja, .png kuvia käyttöliittymää varten, sekä valmiiksi tallennetun soundboard tiedoston joka ladataan ohjelman käynnistyessä. 

Jotta .jar tiedosto toimii sen kanssa samasta hakemistosta täytyy siis löytyä seuraavat kansiot:

-audioFiles (sisältää .wav tiedostoja)

-UI (sisältää .png tiedostoja)

-savedBoards (sisältää tallennettuja soundboardeja)


## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
java -jar Soundboard.jar
```

## Päänäkymä

Kun sovelluksen avaa, aluksi on näkyvissä 9 nappia, jotka on numeroitu nollasta kahdeksaan. Sovellus asettaa automaattisesti käynnistyessään .wav äänitiedostoja nappeihin, jotka voi aktivoida klikkaamalla niitä hiiren vasemmalla napilla.

## Context menu

Äänitiedostojen soittamisen lisäksi sovelluksessa on lisätoiminnallisuutta, johon käyttäjä pääsee käsiksi painamalla soundPadeja, eli käyttöliittymässä näkyviä nappeja hiiren oikealla napilla. Context menun toiminnallisuudella vaikutetaan lähtökohtaisesti siihen soundPadiin, jonka kohdalla käyttäjä klikkaa menun auki.

Seuraavaksi käyttöohjeessa käydään läpi jokainen context menusta löytyvä toiminnallisuus.


## Delete

Klikkaamalla _Delete_ soundPad tyhjentyy. 
Sen käytöstä poistetaan äänitiedosto ja sen nimi muutetaan tekstiksi _"EMPTY"_

## Rename

Klikkaamalla _Rename_ käyttäjä voi muuttaa soundPadin alla olevan tekstin haluamakseen.

## Clone

_Clone_ avulla käyttäjä voi kopioida klikkaamansa soundPadin toisen soundPadin päälle.
Sovellus kysyy soundPadin numeroa jonka päälle valittu soundPad kopioidaan. Huom! soundPadien numerot alkavat luvusta 0. Syötä siis jokin numero nollasta kahdeksaan.
_Clone_ kopioi annettuun soundPad numeroon sekä alkuperäisen soundPadin tiedoston että nimen.

## Swap

_Swap_ avulla käyttäjä voi vaihtaa kahden eri soundPadin paikkaa päänäkymässä.
_Swap_ toimii saman kaltaisesti kuin _Clone_. Käyttäjältä kysytään minkä soundPadin kanssa soundPadin paikkaa vaihdetaan. Syötä numero nollasta kahdeksaan.

## Replace File

Käyttäjä voi lisätä omia .wav muotoisia äänitedostoja ohjelmaan klikkaamalla halutun soundPadin kohdalla hiiren oikeaa nappia ja valitsemalla ilmestyvästä menusta _Replace File_ Sovellus kysyy tiedoston nimeä. Jotta sovellus löytää tiedoston on sen löydyttävä projektin juuresta löytyvästä audioFiles kansiosta. Tiedosto korvaa valitussa soundPadissa aiemmin olleen äänitiedoston ja antaa sille myös uudeksi nimeksi uuden tiedoston nimen.

## Save ja Load

Käyttäjä voi tallentaa soundboardin tiedostoon valitsemalla context menusta kohdan _Save_
Ohjelma kysyy minkä nimen käyttäjä haluaa tiedostolle ja lisää tiedoston projektin juuresta löytyvään savedBoards kansioon.

Käyttäjä voi avata tallennetun soundboardin valitsemalla context menusta _Load_ ja syöttämällä projektin savedBoards kansiosta löytyvän tiedoston nimen.

