package soundboard.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import soundboard.logic.Board;

/**
 * Class responsible of handling the event of user leftclicking a soundpad in
 * the UI.
 */
public class SoundPadHandler implements EventHandler<ActionEvent> {

    private Board soundBoard;

    public SoundPadHandler(Board soundBoard) {
        this.soundBoard = soundBoard;
    }

    /**
     * 
     * Uses the leftclick of user to identify the SoundPad the user wants to use to play a .wav file.
     *
     * @param event Left click by user.
     * 
     */
    @Override
    public void handle(ActionEvent event) {
        Button x = (Button) event.getSource();
        soundBoard.useSoundPad(x.getId());
    }
}
