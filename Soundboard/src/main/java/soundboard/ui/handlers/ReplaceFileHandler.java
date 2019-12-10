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

public class ReplaceFileHandler extends AbstractHandler {

    private Board soundBoard;
    private ArrayList<SoundPad> soundPadList;
    private Pane root;

    public ReplaceFileHandler(Board soundBoard, Pane root) {
        this.soundBoard = soundBoard;
        this.root = root;
    }

    @Override
    public void handle(ActionEvent event) {
        //window to type in newFile
        MenuItem x = (MenuItem) event.getSource();
        this.soundPadList = soundBoard.copyList();

        this.createStage(soundPadList.get(Integer.parseInt(x.getId()))
                .getFilename());

        //Defining the submit button
        Button newFile = new Button("Submit new file");
        GridPane.setConstraints(newFile, 1, 0);

        newFile.setOnAction((ActionEvent submitEvent) -> {
            String newFileName = userText.getText();
            soundBoard.replaceFile(x.getId(), newFileName);
            ((Button) root.getChildren().get(Integer.parseInt(x.getId()) + 1))
                    .setText(x.getId() + ". " + newFileName);
            stage.close();
        });
        update(newFile);

    }
}
