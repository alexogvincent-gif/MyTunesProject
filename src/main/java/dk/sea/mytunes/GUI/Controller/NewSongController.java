package dk.sea.mytunes.GUI.Controller;

import dk.sea.mytunes.BE.Song;
import dk.sea.mytunes.GUI.Model.SongModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class NewSongController {
    @FXML
    private TextField txtSongTitle, txtArtist;

    private SongModel songModel;

    public void setSongModel(SongModel songModel) {
        this.songModel = songModel;
    }

    public void btnClickFindFile(ActionEvent actionEvent) {
    }

    @FXML
    public void btnClickDone(ActionEvent actionEvent) {
        if (!txtSongTitle.getText().isEmpty() && !txtArtist.getText().isEmpty()) {
            try {
                Song newSong = new Song(-1, txtSongTitle.getText(), txtArtist.getText(), "", 0, "");
                songModel.addSong(newSong);

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(e.getMessage());
                alert.showAndWait();
                return;
            }
            ((Stage) txtSongTitle.getScene().getWindow()).close();
        }
    }
}
