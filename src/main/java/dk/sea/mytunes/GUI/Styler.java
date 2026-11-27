package dk.sea.mytunes.GUI;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class Styler {

    private static final String CSS = Styler.class.getResource("/dk/sea/mytunes/style.css").toExternalForm();

    public static Scene createScene(Parent root) {
        Scene scene = new Scene(root);
        scene.getStylesheets().add(CSS);
        return scene;
    }

    public static Scene createScene(Parent root, double width, double height) {
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(CSS);
        return scene;
    }
}
