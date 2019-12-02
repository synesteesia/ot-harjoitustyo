package soundboard.ui;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import soundboard.logic.Board;
import soundboard.logic.SoundPad;

public class CloneHandler extends AbstractHandler {

    private Board soundBoard;
    private ArrayList<SoundPad> soundPadList;
    private Pane root;

    public CloneHandler(Board soundBoard, Pane root) {
        this.soundBoard = soundBoard;
        this.root = root;
    }

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
                    .setText(soundPadList.get(Integer.parseInt(x.getId())).getSoundPadName());

            soundBoard.cloneSoundPad(x.getId(), toBeReplaced);

            stage.close();
        });
        grid.getChildren().add(clone);

        Scene stageScene = new Scene(grid, 300, 50);
        stage.setScene(stageScene);
        stage.show();

    }
}
