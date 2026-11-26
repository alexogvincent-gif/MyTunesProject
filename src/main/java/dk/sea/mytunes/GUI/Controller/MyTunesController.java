package dk.sea.mytunes.GUI.Controller;

import dk.sea.mytunes.BE.Song;
import dk.sea.mytunes.GUI.Model.SongModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class  MyTunesController implements Initializable {
    @FXML
    private TableView<Song> tblViewSong;

    @FXML
    private TableColumn<Song, String> colTitle;

    @FXML
    private TableColumn<Song, Integer> colYear;

    @FXML
    private SongModel songModel;

    public MyTunesController(){
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

    public void btnClickAddSong(ActionEvent actionEvent) {
       try {
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dk/sea/mytunes/newSong.fxml"));
           Parent root = fxmlLoader.load();

           NewSongController controller = fxmlLoader.getController();
           controller.setSongModel(songModel);

           Stage stage = new Stage();
           stage.setTitle("New Song");
           stage.setScene(new Scene(root));
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.show();
       } catch (Exception e) {
           displayError(e);
       }
    }

    public void btnClickDeleteSong(ActionEvent actionEvent) {
    }

    public void btnClickUpdateSong(ActionEvent actionEvent) {
    }

    public void bntClickAddsSongPlaylist(ActionEvent primaryStage) throws IOException {
    }

    public void bntClickRemoveSongPlaylist(ActionEvent actionEvent) {

    }
    @FXML

    public void btnClickPlay(ActionEvent actionEvent) {
        String file = String.valueOf(new File("/MyTunes/audio/song1.mp3"));
        MediaPlayer player = new MediaPlayer(new Media(file));
        player.play();
    }

    public void btnClickPause(ActionEvent actionEvent) {
    }
}
