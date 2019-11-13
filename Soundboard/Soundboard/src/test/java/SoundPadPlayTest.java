/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import classes.SoundPad;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author llmlks
 */
public class SoundPadPlayTest {

    public SoundPadPlayTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {

    }

    @Test
    public void constructorSoundPadWorks() {
        SoundPad testPad = new SoundPad("test.wav", 1);
        assertEquals("test.wav", testPad.getFilename());
    }

    @Test
    public void playSoundWorks() {
        SoundPad testPad = new SoundPad("test.wav", 1);
        assertTrue(testPad.playSound());
    }

}
