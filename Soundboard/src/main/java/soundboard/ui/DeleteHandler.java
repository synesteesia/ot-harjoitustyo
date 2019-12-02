package soundboard.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import soundboard.logic.Board;

public class DeleteHandler implements EventHandler<ActionEvent> {

    private Board soundBoard;
    private Pane root;

    public DeleteHandler(Board soundBoard, Pane root) {
        this.soundBoard = soundBoard;
        this.root = root;
    }

    @Override
    public void handle(ActionEvent event) {
        MenuItem x = (MenuItem) event.getSource();
        soundBoard.deleteSoundPad(x.getId());
        ((Button) root.getChildren().get(Integer.parseInt(x.getId()) + 1))
                    .setText(" ");
    }
}
