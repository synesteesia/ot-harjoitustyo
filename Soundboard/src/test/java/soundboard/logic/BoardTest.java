package soundboard.logic;


import soundboard.logic.Board;
import soundboard.logic.SoundPad;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BoardTest {

    private final PrintStream originalOut = System.out;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream printStream;
    private Board testBoard;

    public BoardTest() {
    }

    @Before
    public void setUp() {
        testBoard = new Board();
        testBoard.createSoundPad("test.wav");
        testBoard.createSoundPad("Hat1.wav");

        printStream = new PrintStream(outContent);
        System.setOut(printStream);
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void useSoundPadHandlesInvalidInput() {
        testBoard.useSoundPad("Kissa");
        assertTrue(outContent.toString().contains(Board.ERROR_NOT_A_NUMBER));
    }

    @Test
    public void useSoundPadHandlesInvalidNumber() {
        testBoard.useSoundPad("10");
        assertTrue(outContent.toString().contains(Board.INVALID_NUMBER));
    }

    @Test
    public void useDeletePadWorks() {
        testBoard.deleteSoundPad("0");
        assertEquals("EMPTY", testBoard.copyList().get(0).getFilename());
        assertEquals("EMPTY", testBoard.copyList().get(0).getSoundPadName());

    }

    @Test
    public void renameSoundPadWorks() {
        testBoard.renameSoundPad("0", "working");
        ArrayList<SoundPad> clone = testBoard.copyList();
        assertEquals("working", clone.get(0).getSoundPadName());

    }

    @Test
    public void replaceFile() {
        testBoard.replaceFile("0", "Kick1.wav");
        ArrayList<SoundPad> clone = testBoard.copyList();
        assertEquals("Kick1.wav", clone.get(0).getFilename());
    }

    @Test
    public void cloneSoundPadWorks() {
        testBoard.cloneSoundPad("0", "1");
        ArrayList<SoundPad> clone = testBoard.copyList();
        assertEquals("test.wav", clone.get(0).getFilename());
        assertEquals("test.wav", clone.get(0).getSoundPadName());

    }
    
    @Test
    public void cloneSoundPadHandlesInvalidInput() {
        testBoard.cloneSoundPad("kissa", "koira");
        assertTrue(outContent.toString().contains(Board.ERROR_NOT_A_NUMBER));
    }

    @Test
    public void cloneSoundPadHandlesInvalidNumber() {
        testBoard.cloneSoundPad("10", "11");
        assertTrue(outContent.toString().contains(Board.INVALID_NUMBER));
    }

    @Test
    public void swapWorks() {
        testBoard.swapSoundPads("0", "1");
        ArrayList<SoundPad> clone = testBoard.copyList();
        assertEquals("Hat1.wav", clone.get(0).getFilename());
        assertEquals("test.wav", clone.get(1).getFilename());

    }
    
    @Test
    public void swapHandlesInvalidInput() {
        testBoard.swapSoundPads("kissa", "koira");
        assertTrue(outContent.toString().contains(Board.ERROR_NOT_A_NUMBER));
    }

    @Test
    public void swapHandlesInvalidNumber() {
        testBoard.swapSoundPads("10", "11");
        assertTrue(outContent.toString().contains(Board.INVALID_NUMBER));
    }

}
