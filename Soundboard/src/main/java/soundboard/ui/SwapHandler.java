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

public class SwapHandler extends AbstractHandler {

    private Board soundBoard;
    private ArrayList<SoundPad> soundPadList;
    private Pane root;

    public SwapHandler(Board soundBoard, Pane root) {
        this.soundBoard = soundBoard;
        this.root = root;
    }

    @Override
    public void handle(ActionEvent event) {
        //window to type in swap number
        MenuItem x = (MenuItem) event.getSource();
        this.soundPadList = soundBoard.copyList();

        this.createStage("swap with number");

        //Defining the swap button
        Button swap = new Button("Swap");
        GridPane.setConstraints(swap, 1, 0);

        swap.setOnAction((ActionEvent submitEvent) -> {
            String swapNumber = userText.getText();
            soundBoard.swapSoundPads(x.getId(), swapNumber);

            ((Button) root.getChildren().get(Integer.parseInt(swapNumber) + 1))
                    .setText(soundPadList.get(Integer.parseInt(x.getId())).getSoundPadName());

            ((Button) root.getChildren().get(Integer.parseInt(x.getId()) + 1))
                    .setText(soundPadList.get(Integer.parseInt(swapNumber)).getSoundPadName());

            stage.close();
        });
        grid.getChildren().add(swap);

        Scene stageScene = new Scene(grid, 300, 50);
        stage.setScene(stageScene);
        stage.show();

    }
}
