package soundboard.ui.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import soundboard.logic.Board;

/**
 * Class responsible of handling the event of user choosing the Delete option of
 * a SoundPad object in the UI.
 *
 */
public class DeleteHandler implements EventHandler<ActionEvent> {

    private Board soundBoard;
    private Pane root;

    public DeleteHandler(Board soundBoard, Pane root) {
        this.soundBoard = soundBoard;
        this.root = root;
    }

    /**
     * Uses the click of user to identify the SoundPad the user wants to delete, then using Board classes delete method and renaming the soundpad in the UI.
     * @param event Click by user.
     */
    @Override
    public void handle(ActionEvent event) {
        MenuItem x = (MenuItem) event.getSource();
        soundBoard.deleteSoundPad(x.getId());
        ((Button) root.getChildren().get(Integer.parseInt(x.getId()) + 1))
                .setText(x.getId() + ". " + "EMPTY");
    }
}
