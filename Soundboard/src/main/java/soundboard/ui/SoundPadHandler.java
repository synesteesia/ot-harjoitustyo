
package soundboard.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import soundboard.logic.Board;


public class SoundPadHandler implements EventHandler<ActionEvent> {

    private Board soundBoard;

    public SoundPadHandler(Board soundBoard) {
        this.soundBoard = soundBoard;
    }

    @Override
    public void handle(ActionEvent event) {
        Button x = (Button) event.getSource();
        soundBoard.useSoundPad(x.getId());
    }
}
