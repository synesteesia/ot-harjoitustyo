package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void saldoOikein() {
        assertEquals(10, kortti.saldo());
    }

    @Test
    public void saldoKasvaaOikein() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());
    }

    @Test
    public void saldoPieneneeOikein() {
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.0", kortti.toString());
    }

    @Test
    public void saldoEiMeneMiinukselle() {
        kortti.otaRahaa(20);
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void rahaaRiittavastiBooleanTrue() {
        assertTrue(kortti.otaRahaa(10));
    }

    @Test
    public void rahaaEiRiittavastiBooleanTrue() {
        assertFalse(kortti.otaRahaa(12));
    }

}
