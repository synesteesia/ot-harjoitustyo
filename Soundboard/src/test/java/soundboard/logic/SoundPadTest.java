package soundboard.logic;

import soundboard.logic.SoundPad;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SoundPadTest {

    SoundPad testPad;

    public SoundPadTest() {
    }

    @Before
    public void setUp() {
        testPad = new SoundPad("test.wav", 1);
    }

    @Test
    public void constructorSoundPadWorks() {
        assertEquals("test.wav", testPad.getFilename());
    }

    @Test
    public void playSoundWorks() {
        assertTrue(testPad.playSound());
    }

    @Test
    public void playSoundWithNoFileWorks() {
       SoundPad testPadNoFile = new SoundPad("", 1);

        assertTrue(testPadNoFile.playSound());

    }
}
