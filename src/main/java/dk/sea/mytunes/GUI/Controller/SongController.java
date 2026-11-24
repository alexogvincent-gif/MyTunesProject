package dk.sea.mytunes.GUI.Controller;

import dk.sea.mytunes.BE.Song;
import dk.sea.mytunes.GUI.Model.SongModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SongController implements Initializable {
    @FXML
    private TableView<Song> tblViewSong;

    @FXML
    private TableColumn<Song, String> colTitle;

    @FXML
    private TableColumn<Song, Integer> colYear;

    @FXML
    private TextField txtSong, txtArtist;
    @FXML
    private SongModel songModel;

    public SongController(){
        try {
        songModel = new SongModel();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void displayError(Throwable t) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(t.getMessage());
        alert.showAndWait();
    }
}
