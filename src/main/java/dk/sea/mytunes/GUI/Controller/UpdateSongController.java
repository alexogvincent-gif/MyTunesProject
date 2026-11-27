package dk.sea.mytunes.GUI.Controller;

import dk.sea.mytunes.BE.Song;
import dk.sea.mytunes.GUI.Model.SongModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateSongController {
    @FXML
    private TextField txtSongTitle, txtArtist, txtCategory, txtLength, txtFilepath;

    private SongModel songModel;
    private Song song;

    public void setSongModel(SongModel songModel) {
        this.songModel = songModel;
    }

    public void setSong(Song song) {
        this.song = song;
        txtSongTitle.setText(song.getTitle());
        txtArtist.setText(song.getArtist());
        txtCategory.setText(song.getCategory());
        txtLength.setText(String.valueOf(song.getLength()));
        txtFilepath.setText(song.getFilePath());
    }

    @FXML
    private void btnClickUpdateFile(ActionEvent actionEvent) throws Exception {

        Song updated = new Song(song.getId(), txtSongTitle.getText(), txtArtist.getText(), txtCategory.getText(), Integer.parseInt(txtLength.getText()), txtFilepath.getText());

        songModel.updateSong(updated);
        ((Stage) txtSongTitle.getScene().getWindow()).close();
    }

    @FXML
    public void btnClickUpdateDone(ActionEvent actionEvent) {

        Button source = (Button) actionEvent.getSource();

        Stage stage = (Stage) source.getScene().getWindow();

        stage.close();
    }
}