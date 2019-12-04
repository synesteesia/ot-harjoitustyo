package soundboard.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Board implements Serializable {

    static final String ERROR_NOT_A_NUMBER = "Input not a number ";
    static final String INVALID_NUMBER = "Invalid number ";
    private static final String EMPTY_STRING = "EMPTY";

    private final ArrayList<SoundPad> soundPadList;

    public Board() {
        this.soundPadList = new ArrayList<>();
    }

    public ArrayList<SoundPad> copyList() {

        return (ArrayList<SoundPad>) soundPadList.clone();
    }

    public SoundPad createSoundPad(String fileName) {
        //create a pad and add it to the pad list
        SoundPad newSoundPad = new SoundPad(fileName, this.soundPadList.size());
        this.soundPadList.add(newSoundPad);
        return newSoundPad;
    }

    public void useSoundPad(String padNumberString) {
        //turn string to int and call playSound method of the pad that has same id
        try {
            int padNumber = Integer.parseInt(padNumberString);
            this.soundPadList.get(padNumber).playSound();

        } catch (NumberFormatException e) {
            System.out.print(ERROR_NOT_A_NUMBER);
            System.out.print(e.getMessage());

        } catch (IndexOutOfBoundsException ie) {
            System.out.print(INVALID_NUMBER);
            System.out.print(ie.getMessage());
        }
    }

    public void deleteSoundPad(String padNumberString) {
        //set a pads file and name to empty

        int padNumber = Integer.parseInt(padNumberString);
        this.soundPadList.get(padNumber).setFilename(EMPTY_STRING);
        this.soundPadList.get(padNumber).setSoundPadName(EMPTY_STRING);

    }

    public void renameSoundPad(String padNumberString, String newName) {
        //find pad by its number and replace its name with new String
        int padNumber = Integer.parseInt(padNumberString);
        this.soundPadList.get(padNumber).setSoundPadName(newName);

    }

    public void replaceFile(String padNumberString, String newFile) {
        //find button by its number, then replace its audio file path with new String.
        //replace button name with new file name
        int padNumber = Integer.parseInt(padNumberString);
        this.soundPadList.get(padNumber).setFilename(newFile);
        this.soundPadList.get(padNumber).setSoundPadName(newFile);

    }

    public void cloneSoundPad(String toBeClonedString, String toBeReplaced) {
        //replace file path and name to be equal to another pad
        try {
            int toBeCloned = Integer.parseInt(toBeClonedString);
            this.replaceFile(toBeReplaced, this.soundPadList.get(toBeCloned).getFilename());

        } catch (NumberFormatException e) {
            System.out.print(ERROR_NOT_A_NUMBER);
            System.out.print(e.getMessage());

        } catch (IndexOutOfBoundsException ie) {
            System.out.print(INVALID_NUMBER);
            System.out.print(ie.getMessage());
        }
    }

    public void swapSoundPads(String firstPadString, String secondPadString) {
        //swap places of two buttons in the list
        try {
            int firstPad = Integer.parseInt(firstPadString);
            int secondPad = Integer.parseInt(secondPadString);
            Collections.swap(this.soundPadList, firstPad, secondPad);

        } catch (NumberFormatException e) {
            System.out.print(ERROR_NOT_A_NUMBER);
            System.out.print(e.getMessage());

        } catch (IndexOutOfBoundsException ie) {
            System.out.print(INVALID_NUMBER);
            System.out.print(ie.getMessage());
        }

    }

    public void loadSavedBoard(String file) {
        Board savedBoard = BoardIO.readBoardFromFile(file);

        this.soundPadList.clear();
        this.soundPadList.addAll(savedBoard.copyList());
    }

    public void saveBoardToFile(String file) {
        BoardIO.writeBoardToFile(this, file);
    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        for (SoundPad soundPad : soundPadList) {
            outputString.append(soundPad.toString());
        }
        return outputString.toString();
    }
}
