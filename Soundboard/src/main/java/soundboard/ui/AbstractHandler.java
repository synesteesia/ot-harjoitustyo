
package soundboard.ui;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import soundboard.logic.Board;
import soundboard.logic.SoundPad;


public abstract class AbstractHandler implements EventHandler<ActionEvent> {
    
    protected Board soundBoard;
    protected ArrayList<SoundPad> soundPadList;
    protected Stage stage;
    protected GridPane grid;
    protected TextField userText;

    public AbstractHandler() {
    }

    protected void createStage(String textFieldName) {
        stage = new Stage();
        //Creating a GridPane container
        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        //Defining the user text field
        userText = new TextField(textFieldName);
        userText.setPrefColumnCount(10);
        userText.getText();
        GridPane.setConstraints(userText, 0, 0);
        grid.getChildren().add(userText);
    }
    
}
