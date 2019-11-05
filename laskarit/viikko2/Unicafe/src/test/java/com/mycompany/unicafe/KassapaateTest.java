/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mikko
 */
public class KassapaateTest {

    Kassapaate kassa;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }

    @Test
    public void luotuKassaOlemassa() {
        assertTrue(kassa != null);
    }

    @Test
    public void saldoAlussaOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void lounaatAlussaOikein() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiKunMaksuOnRiittava() {
        kassa.syoEdullisesti(240);
        kassa.syoMaukkaasti(400);
        kassa.syoMaukkaasti(100);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100640, kassa.kassassaRahaa());
        assertEquals(100, kassa.syoEdullisesti(340));

    }

    @Test
    public void kateisostoToimiiKunMaksuEiRiittava() {
        kassa.syoEdullisesti(140);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(100, kassa.syoMaukkaasti(100));

    }

    @Test
    public void korttiostoToimiiKunKortillaTarpeeksi() {
        Maksukortti rikas = new Maksukortti(10000);
        kassa.syoEdullisesti(rikas);
        assertEquals(10000 - 240, rikas.saldo());
        assertTrue(kassa.syoEdullisesti(rikas));
        assertEquals(2, kassa.edullisiaLounaitaMyyty());

        kassa.syoMaukkaasti(rikas);
        assertEquals(10000 - 880, rikas.saldo());
        assertTrue(kassa.syoMaukkaasti(rikas));
        assertEquals(2, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());

    }

    @Test
    public void korttiostoToimiiKunKortillaEiTarpeeksi() {
        Maksukortti koyha = new Maksukortti(10);
        kassa.syoEdullisesti(koyha);
        assertEquals(10, koyha.saldo());
        assertFalse(kassa.syoEdullisesti(koyha));
        assertEquals(0, kassa.edullisiaLounaitaMyyty());

        kassa.syoMaukkaasti(koyha);
        assertEquals(10, koyha.saldo());
        assertFalse(kassa.syoMaukkaasti(koyha));
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());

    }

    @Test
    public void korttiLataus() {
        Maksukortti lataus = new Maksukortti(100);
        kassa.lataaRahaaKortille(lataus, 100);
        assertEquals(200, lataus.saldo());
        assertEquals(100100, kassa.kassassaRahaa());

        Maksukortti miinusLataus = new Maksukortti(100);
        kassa.lataaRahaaKortille(miinusLataus, -100);
        assertEquals(100, miinusLataus.saldo());
        assertEquals(100100, kassa.kassassaRahaa());
    }

}
