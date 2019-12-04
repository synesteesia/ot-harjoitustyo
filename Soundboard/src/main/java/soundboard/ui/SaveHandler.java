/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soundboard.ui;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import soundboard.logic.Board;
import soundboard.logic.SoundPad;


class SaveHandler extends AbstractHandler {


    private Board soundBoard;
    private ArrayList<SoundPad> soundPadList;
    private Pane root;

    public SaveHandler(Board soundBoard, Pane root) {
        this.soundBoard = soundBoard;
        this.root = root;
    }

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
        grid.getChildren().add(saveBoard);

        Scene stageScene = new Scene(grid, 300, 50);
        stage.setScene(stageScene);
        stage.show();

    }
}
