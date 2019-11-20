package classes;


import java.util.ArrayList;
import java.util.Collections;

public class Board {

    private ArrayList<SoundPad> buttonList;

    public Board() {
        this.buttonList = new ArrayList<SoundPad>();


    }
    
    public int getNumberOfButtons(){
        return this.buttonList.size();
    }

    public void createSoundPad(String fileName) {
        //create a button and add it to the buttons list
        SoundPad newSoundPad = new SoundPad(fileName, this.buttonList.size() + 1);
        this.buttonList.add(newSoundPad);

    }
    

    
    public void useSoundPad(String padNumberString){
        int padNumber = Integer.parseInt(padNumberString);
        this.buttonList.get(padNumber - 1).playSound();
    }

    public void deleteSoundPad(int buttonNumber) {
        //find button by its number and delete it, then update all buttonNumbers
        for (int i = 0; i < this.buttonList.size(); i++) {
            if (buttonNumber == this.buttonList.get(i).getButtonNumber()) {
                this.buttonList.remove(i);
                for (int ii = 0; ii < this.buttonList.size(); ii++) {
                    this.buttonList.get(ii).setButtonNumber(ii + 1);
                }

            }
        }

    }

    public void renameSoundPad(int buttonNumber, String newName) {
        //find button by its number and replace its name with new String
        for (int i = 0; i < this.buttonList.size(); i++) {
            if (buttonNumber == (this.buttonList.get(i).getButtonNumber())) {
                this.buttonList.get(i).setButtonName(newName);

            }
        }

    }

    public void replaceFile(int buttonNumber, String newFile) {
        //find button by its number, then replace its audio file path with new String.
        //replace button name with new file name
        for (int i = 0; i < this.buttonList.size(); i++) {
            if (buttonNumber == (this.buttonList.get(i).getButtonNumber())) {
                this.buttonList.get(i).setFilename(newFile);
                this.buttonList.get(i).setButtonName(newFile);
                return;
            }
        }

    }

    public void cloneSoundPad(int buttonNumber) {
        //find button by its number, create new button with same file path
        //copy original buttons name to the new button
        //add new button to the list
        for (int i = 0; i < this.buttonList.size(); i++) {
            if (buttonNumber == (this.buttonList.get(i).getButtonNumber())) {
                SoundPad uusiNappi = new SoundPad(this.buttonList.get(i).getFilename(), this.buttonList.size() + 1);
                uusiNappi.setButtonName(this.buttonList.get(i).getButtonName());
                this.buttonList.add(uusiNappi);

            }
        }

    }
    //swap places of two buttons in the list
    public void swapSoundPads(int buttonNumber, int swapNumber) {
        Collections.swap(this.buttonList, buttonNumber, swapNumber);

    }
}
