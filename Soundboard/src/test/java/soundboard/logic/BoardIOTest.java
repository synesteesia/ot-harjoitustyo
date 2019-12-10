package soundboard.logic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardIOTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream printStream;

    public BoardIOTest() {
    }

    @Before
    public void setUp() {

        printStream = new PrintStream(outContent);

        System.setOut(printStream);
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void errorNoSuchFileWorks() {

        BoardIO.readBoardFromFile("thisBoardDoesNotExsist");
        assertTrue(outContent.toString().contains(BoardIO.ERROR_NO_SUCH_FILE));
    }

    @Test
    public void errorReadingFileWorks() {

        BoardIO.readBoardFromFile("test.wav");
        assertTrue(outContent.toString().contains(BoardIO.ERROR_READING_FILE));
    }

    @Test
    public void errorSavingFileWorks() {
        Board testBoard = new Board();
        BoardIO.writeBoardToFile(testBoard, "");
        assertTrue(outContent.toString().contains(BoardIO.ERROR_SAVING_FILE));
        
    }
    
        @Test
    public void savingAndLoadingFileWorks() {
        Board testBoard = new Board();
        BoardIO.writeBoardToFile(testBoard, "loadTest");
        BoardIO.readBoardFromFile("loadTest");
        assertTrue(outContent.toString().contains(BoardIO.LOAD_SUCCESSFULL));
        
    }
}
