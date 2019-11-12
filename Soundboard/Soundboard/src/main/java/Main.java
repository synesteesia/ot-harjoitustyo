
import java.util.ArrayList;
import java.util.Collections;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mikko
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Button> buttonList = new ArrayList();
        int buttonNumber = 0;
        int swapNumber = 0;
        int activationNumber = 0;
        String fileName = "dummy";

        //user clicks createbutton
        //user gives file name - update String filename
        fileName = "test.wav";
        //trigger buttonList = createButton
        buttonList = createButton(buttonList, fileName);

        //user clicks a button
        //set activation number to buttons number
        activationNumber = 1;
        //trigger buttons method .playSound
        buttonList.get(activationNumber - 1).playSound();

        //user clicks rename button
        //user gives button number and new name
        //update buttonNuber and fileName
        buttonNumber = 1;
        fileName = "newName";
        //trigger buttonList = renameButton

        //user clicks replace button
        //user gives button number and new file path
        //update buttonNumber and fileName
        buttonNumber = 1;
        fileName = "newPath";
        //trigger buttonList = replaceButton;

        //user clicks delete button
        //user gives button number
        //update buttonNumber accordingly
        buttonNumber = 1;
        //trigger buttonlist = deleteButton
        buttonList = deleteButton(buttonList, buttonNumber);
    }

    public static ArrayList createButton(ArrayList lista, String fileName) {
        //create a button and add it to the buttons list
        Button uusiNappi = new Button(fileName, lista.size() + 1);
        lista.add(uusiNappi);
        return lista;
    }

    public static ArrayList deleteButton(ArrayList<Button> lista, int buttonNumber) {
        //find button by its number and delete it, then update all buttonNumbers
        for (int i = 0; i < lista.size(); i++) {
            if (buttonNumber == lista.get(i).getButtonNumber()) {
                lista.remove(i);
                for (int ii = 0; ii < lista.size(); ii++) {
                    lista.get(ii).setButtonNumber(ii + 1);
                }
                return lista;
            }
        }
        return lista;
    }

    public static ArrayList renameButton(ArrayList<Button> lista, int buttonNumber, String newName) {
        //find button by its number and replace its name with new String
        for (int i = 0; i < lista.size(); i++) {
            if (buttonNumber == (lista.get(i).getButtonNumber())) {
                lista.get(i).setButtonName(newName);
                return lista;
            }
        }
        return lista;
    }

    public static ArrayList replaceFile(ArrayList<Button> lista, int buttonNumber, String newFile) {
        //find button by its number, then replace its audio file path with new String.
        //replace button name with new file name
        for (int i = 0; i < lista.size(); i++) {
            if (buttonNumber == (lista.get(i).getButtonNumber())) {
                lista.get(i).setFilename(newFile);
                lista.get(i).setButtonName(newFile);
                return lista;
            }
        }
        return lista;
    }

    public static ArrayList cloneButton(ArrayList<Button> lista, int buttonNumber) {
        //find button by its number, create new button with same file path
        //copy original buttons name to the new button
        //add new button to the list
        for (int i = 0; i < lista.size(); i++) {
            if (buttonNumber == (lista.get(i).getButtonNumber())) {
                Button uusiNappi = new Button(lista.get(i).getFilename(), lista.size() + 1);
                uusiNappi.setButtonName(lista.get(i).getButtonName());
                lista.add(uusiNappi);
                return lista;
            }
        }
        return lista;
    }

    public static ArrayList swapButtons(ArrayList<Button> lista, int buttonNumber, int swapNumber) {
        Collections.swap(lista, buttonNumber, swapNumber);
        return lista;
    }

}
