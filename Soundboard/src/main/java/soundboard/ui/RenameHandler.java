
package soundboard.ui;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import soundboard.logic.Board;


public class RenameHandler extends AbstractHandler {

    private Pane root;

    public RenameHandler(Board soundBoard, Pane root) {
        this.soundBoard = soundBoard;
        this.root = root;
    }

    @Override
    public void handle(ActionEvent event) {
        //window to type in newName
        MenuItem x = (MenuItem) event.getSource();
        this.soundPadList = soundBoard.copyList();

        this.createStage(soundPadList.get(Integer.parseInt(x.getId()))
                .getSoundPadName());

        //Defining the Rename button
        Button rename = new Button("Rename");
        GridPane.setConstraints(rename, 1, 0);

        rename.setOnAction((ActionEvent submitEvent) -> {
            String newName = userText.getText();
            soundBoard.renameSoundPad(x.getId(), newName);
           
            ((Button) root.getChildren().get(Integer.parseInt(x.getId()) + 1))
                    .setText(newName);
            stage.close();
        });
        grid.getChildren().add(rename);

        Scene stageScene = new Scene(grid, 300, 50);
        stage.setScene(stageScene);
        stage.show();

    }
}
