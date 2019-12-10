package soundboard.logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Class responsible of creating save files and reading them
 */
public class BoardIO {

    public static final String FILENAME = "DefaultSoundBoard";
    static final String ERROR_NO_SUCH_FILE = "File not found ";
    static final String ERROR_READING_FILE = "Error reading file ";
    static final String ERROR_SAVING_FILE = "Error saving file ";
    static final String LOAD_SUCCESSFULL = "Soundboard loaded successfully ";

    /**
     * Creates a new Board object by reading a save file
     *
     *
     * @param file Name of the save file, given by user by typing.
     * @return New board object created by using a save file.
     */
    public static Board readBoardFromFile(String file) {
        Board board = new Board();
        try (FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            board = (Board) objectIn.readObject();
            System.out.println(LOAD_SUCCESSFULL);

        } catch (FileNotFoundException noFile) {
            System.out.println(ERROR_NO_SUCH_FILE);
            
        } catch (Exception ex) {
            System.out.println(ERROR_READING_FILE);
            
        }

        return board;
    }

    /**
     * Creates a save file using text given by Board classes toString method.
     *
     *
     * @param file Name of the save file that is going to be created, given by
     * user.
     */
    public static void writeBoardToFile(Board board, String file) {

        try {

            FileOutputStream fileOut = new FileOutputStream(file);
            try (ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                objectOut.writeObject(board);
            }

        } catch (Exception ex) {
            System.out.println(ERROR_SAVING_FILE);
            
        }
    }
}
