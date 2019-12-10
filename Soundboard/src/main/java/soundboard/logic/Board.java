package soundboard.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class responsible of maintaining a list of SoundPad objects and using their
 * methods.
 */
public class Board implements Serializable {

    static final String ERROR_NOT_A_NUMBER = "Input not a number ";
    static final String INVALID_NUMBER = "Invalid number ";
    private static final String EMPTY_STRING = "EMPTY";

    private final ArrayList<SoundPad> soundPadList;

    public Board() {
        this.soundPadList = new ArrayList<>();
    }

    /**
     * Copies the list containing soundPad objects.
     *
     * @return A copy of list containing soundPads.
     *
     */
    public ArrayList<SoundPad> copyList() {

        return (ArrayList<SoundPad>) soundPadList.clone();
    }

    /**
     * Creates a soundPad object and adds it to a list.
     *
     * @param fileName String to be used in SoundPad constructor, defines file
     * name SoundPad class attempts to use when playing .wav files.
     * @return SoundPad object created by this method.
     */
    public SoundPad createSoundPad(String fileName) {
        SoundPad newSoundPad = new SoundPad(fileName, this.soundPadList.size());
        this.soundPadList.add(newSoundPad);
        return newSoundPad;
    }

    /**
     * Turn string to integer and call playSound method of the SoundPad that has
     * same ID.
     *
     * @param padNumberString ID of the SoundPad.
     */
    public void useSoundPad(String padNumberString) {
        try {
            int padNumber = Integer.parseInt(padNumberString);
            this.soundPadList.get(padNumber).playSound();

        } catch (NumberFormatException e) {
            System.out.print(ERROR_NOT_A_NUMBER);

        } catch (IndexOutOfBoundsException ie) {
            System.out.print(INVALID_NUMBER);

        }
    }

    /**
     * Turn string to integer and place string "EMPTY" to the SoundPad file and
     * name that has same ID as integer.
     *
     * @param padNumberString ID of the SoundPad, given by user by clicking.
     */
    public void deleteSoundPad(String padNumberString) {

        int padNumber = Integer.parseInt(padNumberString);
        this.soundPadList.get(padNumber).setFilename(EMPTY_STRING);
        this.soundPadList.get(padNumber).setSoundPadName(EMPTY_STRING);

    }

    /**
     * Turn string to integer and rename SoundPad that has same id as integer.
     *
     * @param padNumberString ID of the SoundPad, given by user by clicking.
     * @param newName New name for SoundPad given by user.
     */
    public void renameSoundPad(String padNumberString, String newName) {
        int padNumber = Integer.parseInt(padNumberString);
        this.soundPadList.get(padNumber).setSoundPadName(newName);

    }

    /**
     * Turn string to int and replace corresponding SoundPads audio file, also
     * renames the SoundPad.
     *
     * @param padNumberString ID of the SoundPad, given by user by clicking.
     * @param newFile New file for SoundPad to attempt to use, given by userby
     * typing.
     */
    public void replaceFile(String padNumberString, String newFile) {

        int padNumber = Integer.parseInt(padNumberString);
        this.soundPadList.get(padNumber).setFilename(newFile);
        this.soundPadList.get(padNumber).setSoundPadName(newFile);

    }

    /**
     * Clones a SoundPad on another SoundPad object.
     *
     * @param toBeClonedString ID of the SoundPad that is going to be cloned,
     * given by user by clicking.
     * @param toBeReplaced ID of the SoundPad to be replaced by the other
     * SoundPad, given by user by typing.
     */
    public void cloneSoundPad(String toBeClonedString, String toBeReplaced) {
        try {
            int toBeCloned = Integer.parseInt(toBeClonedString);
            this.replaceFile(toBeReplaced, this.soundPadList.get(toBeCloned).getFilename());

        } catch (NumberFormatException e) {
            System.out.print(ERROR_NOT_A_NUMBER);

        } catch (IndexOutOfBoundsException ie) {
            System.out.print(INVALID_NUMBER);

        }
    }

    /**
     * swaps places of two SoundPad objects on the SoundPad list
     *
     * @param firstPadString id of the first SoundPad, given by user by clicking
     * @param secondPadString id of the second SoundPad, given by user by typing
     */
    public void swapSoundPads(String firstPadString, String secondPadString) {
        //swap places of two buttons in the list
        try {
            int firstPad = Integer.parseInt(firstPadString);
            int secondPad = Integer.parseInt(secondPadString);
            Collections.swap(this.soundPadList, firstPad, secondPad);

        } catch (NumberFormatException e) {
            System.out.print(ERROR_NOT_A_NUMBER);

        } catch (IndexOutOfBoundsException ie) {
            System.out.print(INVALID_NUMBER);

        }

    }

    /**
     * Replaces list containing SoundPad objects with a new list read from a
     * load file by BoardIO.
     *
     * @param file Name of the load file, given by user by typing. BoardIO uses
     * it in its constructor.
     */
    public void loadSavedBoard(String file) {
        Board savedBoard = BoardIO.readBoardFromFile(file);

        if (savedBoard != null) {
            this.soundPadList.clear();
            this.soundPadList.addAll(savedBoard.copyList());
        }

    }

    /**
     * Gives Class BoardIO this classes list of SoundPad objects, by converting
     * it to string using this classes toString method, so it can create a save
     * file
     *
     * @param file Name of the save file that is going to be created, given by
     * user.
     */
    public void saveBoardToFile(String file) {
        BoardIO.writeBoardToFile(this, file);
    }

    /**
     * Turns this classes list of SoundPad objects to String.
     *
     */
    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        for (SoundPad soundPad : soundPadList) {
            outputString.append(soundPad.toString());
        }
        return outputString.toString();
    }
}
