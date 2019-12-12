package soundboard.ui;

import soundboard.ui.handlers.SwapHandler;
import soundboard.ui.handlers.CloneHandler;
import soundboard.ui.handlers.SaveHandler;
import soundboard.ui.handlers.RenameHandler;
import soundboard.ui.handlers.DeleteHandler;
import soundboard.ui.handlers.LoadHandler;
import soundboard.ui.handlers.ReplaceFileHandler;
import soundboard.ui.handlers.SoundPadHandler;
import java.util.ArrayList;
import soundboard.logic.Board;
import soundboard.logic.SoundPad;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.WHITE;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import soundboard.logic.BoardIO;

public class SoundboardUi extends Application {

    Board board = new Board();
    int buttonX = 15;
    int buttonY = 20;
    Pane root = new Pane();
    EventHandler soundPadHandler = new SoundPadHandler(board);
    EventHandler deleteHandler = new DeleteHandler(board, root);
    EventHandler renameHandler = new RenameHandler(board, root);
    EventHandler replaceFileHandler = new ReplaceFileHandler(board, root);
    EventHandler cloneHandler = new CloneHandler(board, root);
    EventHandler swapHandler = new SwapHandler(board, root);
    EventHandler saveHandler = new SaveHandler(board, root);
    EventHandler loadHandler = new LoadHandler(board, root);

    @Override
    public void start(Stage primaryStage) {

        root.getChildren().add(this.createBackround());

        for (int i = 1; i < 10; i++) {
            root.getChildren().add(this.createSoundPadButton());
        }

        board.loadSavedBoard(BoardIO.FILENAME);

        for (int i = 1; i < 10; i++) {
            this.setButtonTexts(i);
        }

        Scene scene = new Scene(root, 600, 500);

        primaryStage.setTitle("SoundBoard - Right click to open menu");
        primaryStage.setScene(scene);

        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

    }

    public ImageView createBackround() {
        //create UI backround picture
        ImageView iv = new ImageView();
        Image backround = new Image("file:./src/main/resources/UI/UI.png");
        iv.setImage(backround);

        iv.setFitWidth(600);
        iv.setFitHeight(500);
        return iv;
    }

    public Button createSoundPadButton() {
        //create picture of a button for UI
        //set position depending on int X and Y value
        //set click action
        SoundPad newSoundPad = board.createSoundPad("");

        Image buttonImage = new Image("file:./src/main/resources/UI/UIbutton.png");

        ImageView buttonView = new ImageView();
        buttonView.setImage(buttonImage);
        buttonView.setFitWidth(165);
        buttonView.setFitHeight(125);

        BackgroundImage bgi = new BackgroundImage(buttonImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bgi);

        Button button = new Button(" ", buttonView);

        button.setContentDisplay(ContentDisplay.TOP);
        button.setTextFill(WHITE);

        button.setOpacity(1);
        button.setBackground(bg);
        String id = String.valueOf(newSoundPad.getSoundPadNumber());
        button.setId(id);

        if (this.buttonX > 500) {
            this.buttonY = this.buttonY + 160;
            this.buttonX = 15;
        }
        button.setLayoutX(this.buttonX);
        button.setLayoutY(this.buttonY);
        this.buttonX = this.buttonX + 193;

        button.setContextMenu(this.getMenu(id));

        // button.setOnAction(this.soundPadHandler);
        button.setOnMousePressed(this.soundPadHandler);
        return button;

    }

    public void setButtonTexts(int buttonNumber) {
        ArrayList<SoundPad> copy = board.copyList();
        ((Button) root.getChildren().get(buttonNumber))
                .setText((buttonNumber - 1) + ". " + copy.get(buttonNumber - 1).getSoundPadName());

    }

    private ContextMenu getMenu(String id) {
        //create menu for right click
        //set handlers for each item in menu
        ContextMenu menu = new ContextMenu();
        MenuItem delete = new MenuItem("Delete");
        delete.addEventHandler(EventType.ROOT, deleteHandler);
        delete.setId(id);
        MenuItem rename = new MenuItem("Rename");
        rename.addEventHandler(EventType.ROOT, renameHandler);
        rename.setId(id);
        MenuItem replaceFile = new MenuItem("Replace File");
        replaceFile.addEventHandler(EventType.ROOT, replaceFileHandler);
        replaceFile.setId(id);
        MenuItem clone = new MenuItem("Clone");
        clone.addEventHandler(EventType.ROOT, cloneHandler);
        clone.setId(id);
        MenuItem swap = new MenuItem("Swap");
        swap.addEventHandler(EventType.ROOT, swapHandler);
        swap.setId(id);
        MenuItem save = new MenuItem("Save");
        save.addEventHandler(EventType.ROOT, saveHandler);
        save.setId(id);
        MenuItem load = new MenuItem("Load");
        load.addEventHandler(EventType.ROOT, loadHandler);
        load.setId(id);
        menu.getItems().addAll(delete, rename, replaceFile, clone, swap, save, load);
        return menu;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }
}
