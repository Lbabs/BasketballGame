/*
 * Logan Baburchak
 * Lab 16
 * 4/3/18
 * Professor Haner
 */
package javafxtwo;

import static com.sun.glass.ui.Cursor.setVisible;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Priority.ALWAYS;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//creates class that ectends application
public class JavaFxTwo extends Application {

    int dukeScore = 0;
    int kansasScore = 0;
    GamePane centerPane = new GamePane();

    @Override
    //creates method that takes in parameter stage called primaryStage
    public void start(Stage primaryStage) {
        //creates border plane
        BorderPane border = new BorderPane();

        HBox topPane = new HBox();
        TextField textField = new TextField();
        topPane.getChildren().addAll(textField);
        topPane.setAlignment(Pos.CENTER);

        //creates a bottom pane 
        HBox bottomPane = new HBox(50);
        bottomPane.setPrefHeight(100);
        bottomPane.setPrefWidth(500);
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setStyle("-fx-background-color: #336699;");

        //adds a background image to the center pane
        BackgroundImage myBI = new BackgroundImage(new Image("http://www.goalsandpoles.com/images/northpark3.jpg", 300, 400, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(600, 600, false, false, false, true));
        centerPane.setBackground(new Background(myBI));

        //creates a button with text shoot jumper
        Button btn1 = new Button();
        btn1.setText("Shoot Jumper");
        //has an event when the button is clicked
        Button1HandlerClass btn1Handler = new Button1HandlerClass();
        btn1.setOnAction(btn1Handler);

        //creates a button with text go in for layup
        Button btn2 = new Button();
        btn2.setText("Go in for layup");
        //has event when the button is clicked
        Button2HandlerClass btn2Handler = new Button2HandlerClass();
        btn2.setOnAction(btn2Handler);

        //adds both buttons to the bottom pane
        bottomPane.getChildren().addAll(btn1, btn2);

        //adds the center pane and bottom pane to the border pane
        border.setTop(topPane);
        border.setCenter(centerPane);
        border.setBottom(bottomPane);

        //creates a scene with what is in border of 400x500
        Scene scene = new Scene(border, 400, 500);

        //creates a primary window called nationalchampionship game 
        primaryStage.setTitle("National Championship Game");
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(500);
        primaryStage.minWidthProperty().bind(scene.heightProperty().multiply(1));
        primaryStage.minHeightProperty().bind(scene.widthProperty().multiply(1));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //class that creates the event when button is clicked
    class Button1HandlerClass implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            //when the button is clicked, a number between 0-2 is generated
            //then decides if a team scores or not and the score is then
            //printed to the screen
            centerPane.jumper();
            
        }
    }

    //class that creates the event when button is clicked
    class Button2HandlerClass implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            //when the button is clicked, a number between 0-2 is generated
            //then decides if a team scores or not and the score is then printed
            //to the screen
            centerPane.layup(); 
        }
    }

    class GamePane extends Pane {

        GamePane() {
            this.setPrefWidth(300);
            this.setPrefHeight(400);
            BackgroundImage myBI = new BackgroundImage(new Image("http://www.goalsandpoles.com/images/northpark3.jpg", 300, 400, false, true),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            new BackgroundSize(600, 600, false, false, false, true));
            this.setBackground(new Background(myBI));
            ImageView make = new ImageView(new Image("https://s3.amazonaws.com/my.llfiles.com/00310308/basketball-for-website.jpg"));
            
        }
        public void jumper(){
            boolean isMake = false;
            Random rand = new Random();
            int n = rand.nextInt(3);
            BackgroundImage make = new BackgroundImage(new Image("https://s3.amazonaws.com/my.llfiles.com/00310308/basketball-for-website.jpg", 185, 259, false, true),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            new BackgroundSize(600, 600, false, false, false, true));
            if (n == 0) {
                System.out.println("Duke scored 3 points");
                dukeScore = dukeScore + 3;
                this.setBackground(new Background(make));
                isMake=true;
                
            }
            if (n == 1) {
                System.out.println("Kansas Scored 3 points");
                kansasScore = kansasScore + 3;
                this.setBackground(new Background(make));
                isMake=true;
                
            }
            if (n == 2) {
                System.out.println("The jumper was missed get the rebound");
            }
            System.out.println("The score is Duke : " + dukeScore);
            System.out.println("Kansas: " + kansasScore);
            if(!isMake){
            BackgroundImage myBI = new BackgroundImage(new Image("http://www.goalsandpoles.com/images/northpark3.jpg", 300, 400, false, true),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            new BackgroundSize(600, 600, false, false, false, true));
            this.setBackground(new Background(myBI));
            }
            
        }
        public void layup(){
            boolean isMake = false;
            Random rand = new Random();
            int n = rand.nextInt(3);
            BackgroundImage make = new BackgroundImage(new Image("https://s3.amazonaws.com/my.llfiles.com/00310308/basketball-for-website.jpg", 185, 259, false, true),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            new BackgroundSize(600, 600, false, false, false, true));
            if (n == 0) {
                System.out.println("Duke scored 2 points");
                dukeScore = dukeScore + 2;
                this.setBackground(new Background(make));
                isMake=true;
            }
            if (n == 1) {
                System.out.println("Kansas Scored 2 points");
                kansasScore = kansasScore + 2;
                this.setBackground(new Background(make));
                isMake=true;
            }
            if (n == 2) {
                System.out.println("The layup was missed get the rebound");
            }
            if(!isMake){
            BackgroundImage myBI = new BackgroundImage(new Image("http://www.goalsandpoles.com/images/northpark3.jpg", 300, 400, false, true),
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            new BackgroundSize(600, 600, false, false, false, true));
            this.setBackground(new Background(myBI));
                
            }
            
            System.out.println("The score is Duke : " + dukeScore);
            System.out.println("Kansas: " + kansasScore);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
