package dk.sea.mytunes.GUI.Controller;

import dk.sea.mytunes.BE.Song;
import dk.sea.mytunes.GUI.Model.SongModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class NewSongController {
    @FXML
    private TextField txtSongTitle, txtArtist, txtFilepath;

    private SongModel songModel;

    public void setSongModel(SongModel songModel) {
        this.songModel = songModel;
    }

    public void btnClickFindFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a song");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Audio files", "*.mp3", "*.wav"));

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            txtFilepath.setText(file.getAbsolutePath());

            if (txtSongTitle.getText().isEmpty()) {
                String name = file.getName();
                txtSongTitle.setText(name.substring(0, name.lastIndexOf('.')));
            }
        }
    }

    @FXML
    public void btnClickDone(ActionEvent actionEvent) {
        Button source = (Button) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        if (!txtSongTitle.getText().isEmpty() && !txtArtist.getText().isEmpty()) {
            try {
                Song newSong = new Song(-1, txtSongTitle.getText(), txtArtist.getText(), "", 0, "");
                songModel.addSong(newSong);

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(e.getMessage());
                alert.showAndWait();
            }
        }
    }
}
