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
 * Class responsible of handling the event of user choosing the Load option of a
 * SoundPad object in the UI.
 *
 */
public class LoadHandler extends AbstractHandler {

    private Board soundBoard;
    private ArrayList<SoundPad> soundPadList;
    private Pane root;

    public LoadHandler(Board soundBoard, Pane root) {
        this.soundBoard = soundBoard;
        this.root = root;
    }

    /**
     * Opens a window asking the user for a load file name and opens it
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
        Button loadBoard = new Button("Load board");
        GridPane.setConstraints(loadBoard, 1, 0);

        loadBoard.setOnAction((ActionEvent submitEvent) -> {
            String loadBoardName = userText.getText();
            soundBoard.loadSavedBoard(loadBoardName);

            this.soundPadList = soundBoard.copyList();

            for (int i = 0; i < 9; i++) {
                ((Button) root.getChildren().get(i + 1))
                        .setText(i + ". " + soundPadList.get(i).getSoundPadName());

            }

            stage.close();
        });
        update(loadBoard);

    }

}
