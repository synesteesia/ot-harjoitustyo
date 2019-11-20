package classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author mikko
 */
public class Main extends Application implements EventHandler<ActionEvent> {

    Board testboard = new Board();
    int buttonX = 15;
    int buttonY = 20;


    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();

        root.getChildren().add(this.createBackround());

        for (int i = 1; i < 10; i++) {
            root.getChildren().add(this.createTemplateButton());
        }
        

        Scene scene = new Scene(root, 600, 500);

        primaryStage.setTitle("Test Board");
        primaryStage.setScene(scene);

        primaryStage.show();
        testboard.replaceFile(1, "Clap1.wav");
        testboard.replaceFile(2, "Clap2.wav");
        testboard.replaceFile(3, "Hat1.wav");
        testboard.replaceFile(4, "Hat2.wav");
        testboard.replaceFile(5, "Kick1.wav");
        testboard.replaceFile(6, "Kick2.wav");
        testboard.replaceFile(7, "Perc1.wav");
        testboard.replaceFile(8, "Snare1.wav");
        testboard.replaceFile(9, "Snare2.wav");

        
    }

    @Override
    public void handle(ActionEvent event) {
        Button x = (Button) event.getSource();
        testboard.useSoundPad(x.getId());

    }

    public ImageView createBackround() {
        ImageView iv = new ImageView();
        Image backround = new Image("file:UI.png");
        iv.setImage(backround);

        iv.setFitWidth(600);
        iv.setFitHeight(500);
        return iv;
    }

    public Button createTemplateButton() {
        //create picture of a button for UI
        //set position depending on int X and Y value
        testboard.createSoundPad("");

        Image buttonImage = new Image("file:UIbutton1.png");

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

        Button btn = new Button("", buttonView);
        btn.setOpacity(0);
        btn.setBackground(bg);
        btn.setId(String.valueOf(testboard.getNumberOfButtons()));
        

        if (this.buttonX > 500) {
            this.buttonY = this.buttonY + 160;
            this.buttonX = 15;
        }
        btn.setLayoutX(this.buttonX);
        btn.setLayoutY(this.buttonY);
        this.buttonX = this.buttonX + 193;

        btn.setOnAction(this);
        return btn;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
}
