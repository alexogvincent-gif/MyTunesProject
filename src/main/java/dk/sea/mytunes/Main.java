package dk.sea.mytunes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application{


    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load((Objects.requireNonNull(Main.class.getResource("/dk/sea/mytunes/MyTunes.fxml"))));
        primaryStage.setTitle("MyTunes");
        primaryStage.setScene(new Scene(root, 980, 694));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
