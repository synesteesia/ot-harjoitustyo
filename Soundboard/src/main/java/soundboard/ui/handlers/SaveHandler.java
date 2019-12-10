/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soundboard.ui.handlers;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import soundboard.logic.Board;
import soundboard.logic.SoundPad;

/**
 * Class responsible of handling the event of user choosing the Save option of a
 * SoundPad object in the UI.
 *
 */
public class SaveHandler extends AbstractHandler {


    private Board soundBoard;
    private ArrayList<SoundPad> soundPadList;
    private Pane root;

    public SaveHandler(Board soundBoard, Pane root) {
        this.soundBoard = soundBoard;
        this.root = root;
    }

        /**
     * Opens a window asking the user for a save file name and writes it
     *
     * @param event Click by user.
     */
    @Override
    public void handle(ActionEvent event) {
        //window to type in newFile
        MenuItem x = (MenuItem) event.getSource();
        this.soundPadList = soundBoard.copyList();

        this.createStage("board name");

        //Defining the submit button
        Button saveBoard = new Button("Save board");
        GridPane.setConstraints(saveBoard, 1, 0);

        saveBoard.setOnAction((ActionEvent submitEvent) -> {
            String newBoardName = userText.getText();
            soundBoard.saveBoardToFile(newBoardName);
            stage.close();
        });
        update(saveBoard);
        

    }
}
