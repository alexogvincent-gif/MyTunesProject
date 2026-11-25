package dk.sea.mytunes.GUI.controller;

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

public class MyTunesController implements Initializable {
    @FXML
    private TableView<Song> tblViewSong;

    @FXML
    private TableColumn<Song, String> colTitle;

    @FXML
    private TableColumn<Song, Integer> colYear;

    @FXML
    private TextField txtSongTitle, txtArtist;
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
        if (!txtSongTitle.getText().isEmpty() && !txtArtist.getText().isEmpty()) {

            String songTitle = txtSongTitle.getText();
            String artist =txtArtist.getText();

            Song newSong = new Song(-1, songTitle, artist, "", 0, "");

            try {
                songModel.addSong(newSong);
                txtSongTitle.clear();
                txtArtist.clear();
            } catch (Exception e) {
                displayError(e);
            }
        }
    }

    public void btnClickDeleteSong(ActionEvent actionEvent) {
    }

    public void btnClickUpdateSong(ActionEvent actionEvent) {
    }

    public void bntClickAddsSongPlaylist(ActionEvent actionEvent) {
    }

    public void bntClickRemoveSongPlaylist(ActionEvent actionEvent) {

    }
}
