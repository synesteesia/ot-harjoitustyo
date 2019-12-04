# Arkkitehtuurikuvaus

## Rakenne

Koodin pakkausrakenne on seuraava:

<img src="https://raw.githubusercontent.com/mluukkai/ohjelmistotekniikka-kevat2019/master/web/images/l-11.png" width="160">

Pakkaus _soundboard.ui_ sisältää JavaFX:llä toteutetun käyttöliittymän ja _soundboard.logic_ sovelluslogiikan.

## Käyttöliittymä

Käyttöliittymä sisältää kaksi erillistä näkymää
- pääkäyttöliittymä
- context menun avaama ikkuna

Käyttöliittymä on rakennettu ohjelmallisesti luokassa _soundboard.ui.Main_. Sama luokka lisää käyttöliittymään context menun, jonka jokaisella kohdalla on oma handler luoka.

Käyttöliittymä on pyritty eristämään täysin sovelluslogiikasta, se ainoastaan kutsuu sopivin parametrein sovelluslogiikan toteuttavan olion _Boardin_ metodeja.

Jokainen handler luokka muokkaa pääkäyttöliittymän näkymää toivotun toiminnallisuuden mukaisesti.

## Sovelluslogiikka

Sovelluksen keskeisimmästä toiminnallisuudesta, eli .wav tiedostojen aktivoinnista vastaa luokka SoundPad.

Toiminnallisista kokonaisuuksista vastaa luokka _Board_, joka tarjoaa käyttöliittymän toiminnoille omat metodit. Board luokka sisältää listan SoundPad olioita, joka on sovelluksen keskeinen tietorakenne.


## Tietojen pysyväistallennus

Tiedon tallentamisesta ja lataamisesta vastaa puolestaan luokka _BoardIO_.

### Tiedostot

Sovellus tallettaa soundboardien tiedot erillisiin tiedostoihin.

Sovelluksen juureen on sijoitettu _DefaultSoundBoard_ jota ovellus käyttää käynnistyessään samoin kuin käyttäjä tilanteessa, jossa halutaan avata aiemmin tallennettu näkymä. 

Sovelluksen juuressa on myös kaksi .png tiedostoa joita sovellus käyttää käyttöliittymän rakentamiseen. 

Juuressa on myös .wav tiedostoja joita _DefaultSoundBoard_ käyttää, sekä yksi .wav tiedosto joka on testien käytössä. 

Kaikki tarvittavat tiedostot on pakattu _soundBoardFiles.zip_ tiedostoon jonka voi halutessaan purkaa esimerkiksi .jar suoritushakemistoon.


### Päätoiminnallisuudet

Kuvataan seuraavaksi sovelluksen toimintalogiikka muutaman päätoiminnallisuuden osalta sekvenssikaaviona.

#### .wav tiedoston soittaminen

Sekvenssikaavio kun käyttäjä klikkaa soundPadia päänäkymässä:

<img src="https://github.com/synesteesia/ot-harjoitustyo/blob/master/dokumentointi/Kuvat/SekvenssiClickPad.jpg" width="750">


Painikkeen painamiseen reagoiva handler _SoundPadHandler_ kutsuu sovelluslogiikan metodia _.useSoundPad_ antaen parametriksi soundpad napin idn. _Board_ luokka selvittää idn avulla onko SoundPad olio olemassa. Jos on, se kutsuu kyseisen SoundPad olion metodia _.playsound_, joka puolestaan palauttaa booleanin sen mukaan onnistuuko .wav tiedoston soittaminen.


#### Muut toiminnallisuudet

Sama periaate toistuu sovelluksen kaikissa toiminnallisuuksissa, käyttöliittymän tapahtumakäsittelijä kutsuu sopivaa sovelluslogiikan metodia, sovelluslogiikka päivittää SoundPadien tai listarakenteen tilaa. Kontrollin palatessa käyttöliittymään, päivitetään aktiivinen näkyvä.
