package classes;

import java.util.ArrayList;
import java.util.Collections;

public class Board {

    static final String ERROR_NOT_A_NUMBER = "Input not a number";
    static final String INVALID_NUMBER = "Invalid number";

    private ArrayList<SoundPad> soundPadList;

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

    public void deleteSoundPad(int soundPadNumber) {
        //set a pads file and name to empty
        this.soundPadList.get(soundPadNumber).setFilename("");
        this.soundPadList.get(soundPadNumber).setSoundPadName("");

    }

    public void renameSoundPad(int buttonNumber, String newName) {
        //find pad by its number and replace its name with new String
        this.soundPadList.get(buttonNumber).setSoundPadName(newName);

    }

    public void replaceFile(int soundPadNumber, String newFile) {
        //find button by its number, then replace its audio file path with new String.
        //replace button name with new file name
        this.soundPadList.get(soundPadNumber).setFilename(newFile);
        this.soundPadList.get(soundPadNumber).setSoundPadName(newFile);

    }

    public void cloneSoundPad(int toBeCloned, int toBeReplaced) {
        this.replaceFile(toBeReplaced, this.soundPadList.get(toBeCloned).getFilename());
    }

    //swap places of two buttons in the list
    public void swapSoundPads(int firstPad, int secondPad) {
        Collections.swap(this.soundPadList, firstPad, secondPad);

    }
}
