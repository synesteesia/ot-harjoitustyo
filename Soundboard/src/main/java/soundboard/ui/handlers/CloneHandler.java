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
 * Class responsible of handling the event of user choosing the Clone option of
 * a SoundPad object in the UI.
 *
 */
public class CloneHandler extends AbstractHandler {

    private Board soundBoard;
    private ArrayList<SoundPad> soundPadList;
    private Pane root;

    public CloneHandler(Board soundBoard, Pane root) {
        this.soundBoard = soundBoard;
        this.root = root;
    }

    /**
     * Uses the click of user to identify the SoundPad the user wants to clone,
     * then asks user number of the soundpad to clone on.
     *
     * @param event Click by user.
     */
    @Override
    public void handle(ActionEvent event) {
        //window to type in toBeReplaced
        MenuItem x = (MenuItem) event.getSource();
        this.soundPadList = soundBoard.copyList();

        this.createStage("number to clone on");

        //Defining the clone button
        Button clone = new Button("Clone");
        GridPane.setConstraints(clone, 1, 0);

        clone.setOnAction((ActionEvent submitEvent) -> {
            String toBeReplaced = userText.getText();

            ((Button) root.getChildren().get(Integer.parseInt(toBeReplaced) + 1))
                    .setText(toBeReplaced + ". " + soundPadList.get(Integer.parseInt(x.getId())).getSoundPadName());

            soundBoard.cloneSoundPad(x.getId(), toBeReplaced);

            stage.close();
        });

        update(clone);

    }
}
