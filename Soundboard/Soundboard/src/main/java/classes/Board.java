package classes;


import java.util.ArrayList;
import java.util.Collections;

public class Board {

    private ArrayList<Button> buttonList;

    public Board() {
        ArrayList<Button> buttonList = new ArrayList();

    }

    public void createButton(String fileName) {
        //create a button and add it to the buttons list
        Button uusiNappi = new Button(fileName, this.buttonList.size() + 1);
        this.buttonList.add(uusiNappi);

    }

    public void deleteButton(int buttonNumber) {
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

    public void renameButton(int buttonNumber, String newName) {
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

            }
        }

    }

    public void cloneButton(int buttonNumber) {
        //find button by its number, create new button with same file path
        //copy original buttons name to the new button
        //add new button to the list
        for (int i = 0; i < this.buttonList.size(); i++) {
            if (buttonNumber == (this.buttonList.get(i).getButtonNumber())) {
                Button uusiNappi = new Button(this.buttonList.get(i).getFilename(), this.buttonList.size() + 1);
                uusiNappi.setButtonName(this.buttonList.get(i).getButtonName());
                this.buttonList.add(uusiNappi);

            }
        }

    }

    public void swapButtons(int buttonNumber, int swapNumber) {
        Collections.swap(this.buttonList, buttonNumber, swapNumber);

    }
}
