package soundboard.logic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BoardIO {

    public static final String FILENAME = "DefaultSoundBoard";

    public static Board readBoardFromFile(String file) {
        Board board = new Board();
        try (FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            board = (Board) objectIn.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return board;
    }

    public static void writeBoardToFile(Board board, String file) {

        try {

            FileOutputStream fileOut = new FileOutputStream(file);
            try (ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                objectOut.writeObject(board);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
