# Arkkitehtuurikuvaus

## Rakenne

Koodin pakkausrakenne on seuraava:

<img src="https://raw.githubusercontent.com/synesteesia/ot-harjoitustyo/master/dokumentointi/Kuvat/pakkausUML.jpg" width="160">

Pakkaus _soundboard.ui_ sisältää JavaFX:llä toteutetun käyttöliittymän ja _soundboard.logic_ sovelluslogiikan. Ui pakkaus sisätää myös erikseen paketin _soundboard.ui.handlers_ joka sisältää erilaisia Eventejä käsitteleviä luokkia.

## Projektin luokkakaavio

<img src="https://raw.githubusercontent.com/synesteesia/ot-harjoitustyo/master/dokumentointi/Kuvat/LuokkaUML.jpg" width="160">

## Käyttöliittymä

Käyttöliittymä sisältää kaksi erillistä näkymää
- pääkäyttöliittymä
- context menun avaamat ikkunat

Käyttöliittymä on rakennettu ohjelmallisesti luokassa _soundboard.ui_. Sama luokka lisää käyttöliittymään context menun, jonka jokaisella kohdalla on oma handler luokka.

Käyttöliittymä on pyritty eristämään täysin sovelluslogiikasta, se ainoastaan kutsuu sopivin parametrein sovelluslogiikan toteuttavan olion _Boardin_ metodeja.

Jokainen handler luokka muokkaa pääkäyttöliittymän näkymää toivotun toiminnallisuuden mukaisesti.

## Sovelluslogiikka

Sovelluksen keskeisimmästä toiminnallisuudesta, eli .wav tiedostojen aktivoinnista vastaa luokka SoundPad. Äänitiedostojen soittamisen tekee kuitenkin varsinaisesti luokka ThreadPad.

Toiminnallisista kokonaisuuksista vastaa luokka _Board_, joka tarjoaa käyttöliittymän toiminnoille omat metodit. Board luokka sisältää listan SoundPad olioita, joka on sovelluksen keskeinen tietorakenne.


## Tietojen pysyväistallennus

Tiedon tallentamisesta ja lataamisesta vastaa puolestaan luokka _BoardIO_.

### Tiedostot

Sovellus tallettaa soundboardien tiedot erillisiin tiedostoihin.

Sovelluksen juureen on sijoitettu kansio savedBoards, joka sisältää tiedoston _StartBoard_ jota ovellus käyttää käynnistyessään samoin kuin käyttäjä tilanteessa, jossa halutaan avata aiemmin tallennettu näkymä. Samasta kansiosta löytyy myös kaksi muuta tiedostoa, jotka ovat testien käytössä.

Sovelluksen juuressa on myös kansio UI, joka sisältää kaksi .png tiedostoa joita sovellus käyttää käyttöliittymän rakentamiseen. 

Lisäksi projektin juuresta löytyy kansio audioFiles, jossa on .wav tiedostoja joita _StartBoard_ käyttää, sekä yksi .wav tiedosto joka on testien käytössä. 

Kaikki tarvittavat tiedostot on pakattu _soundBoardFiles.zip_ tiedostoon jonka voi halutessaan purkaa esimerkiksi .jar suoritushakemistoon.


### Päätoiminnallisuudet

Kuvataan seuraavaksi sovelluksen toimintalogiikka ohjelman päätoiminnallisuuden osalta sekvenssikaaviona.

#### .wav tiedoston soittaminen

Sekvenssikaavio kun käyttäjä klikkaa soundPadia päänäkymässä:

<img src="https://raw.githubusercontent.com/synesteesia/ot-harjoitustyo/master/dokumentointi/Kuvat/sekvenssi.jpg" width="750">


Painikkeen painamiseen reagoiva handler _SoundPadHandler_ kutsuu sovelluslogiikan metodia _.useSoundPad_ antaen parametriksi soundpad napin idn. _Board_ luokka selvittää idn avulla onko SoundPad olio olemassa. Jos on, se kutsuu kyseisen SoundPad olion metodia _.playsound_, joka puolestaan palauttaa booleanin sen mukaan onnistuuko .wav tiedoston soittaminen. SoundPad olio luo uuden ThreadPad olion, joka varsinaisesti soittaa ja sulkee äänitiedoston.


#### Muut toiminnallisuudet

Sama periaate toistuu sovelluksen kaikissa toiminnallisuuksissa, käyttöliittymän tapahtumakäsittelijä kutsuu sopivaa sovelluslogiikan metodia, sovelluslogiikka päivittää SoundPadien tai listarakenteen tilaa. Lopuksi AbstractHandler luokka päivittää ui:n päänäkymää mikäli sille on tarvetta.
