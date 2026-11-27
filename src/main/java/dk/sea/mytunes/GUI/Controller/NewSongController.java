package dk.sea.mytunes.GUI.Controller;

import dk.sea.mytunes.BE.Song;
import dk.sea.mytunes.GUI.Model.SongModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.function.Consumer;


public class NewSongController {

    private SongModel songModel;

    @FXML
    private TextField txtSongTitle, txtArtist, txtCategory, txtLength, txtFilepath;

    @FXML
    private TableView<Song> tblSongs;

    public void setSongModel(SongModel songModel) {
        this.songModel = songModel;
    }


    @FXML
    public void btnClickDone(ActionEvent actionEvent) {

        Button source = (Button) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

        if (!txtSongTitle.getText().isEmpty() && !txtArtist.getText().isEmpty() && !txtCategory.getText().isEmpty() && !txtLength.getText().isEmpty() && !txtFilepath.getText().isEmpty()) {
            try {
                Song newSong = new Song(-1, txtSongTitle.getText(), txtArtist.getText(), txtCategory.getText(), Integer.parseInt(txtLength.getText()), txtFilepath.getText());
                songModel.addSong(newSong);

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void btnClickFindFile(ActionEvent actionEvent) {

        Stage mainStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Find file");
        fileChooser.getExtensionFilters().addAll();
        {
            new FileChooser.ExtensionFilter("Audio files", "*.mp3");
            File selectedFile = fileChooser.showOpenDialog(mainStage);
            if (selectedFile != null) {
                txtFilepath.setText(selectedFile.getAbsolutePath());
                getDurationInSeconds(selectedFile, seconds ->{txtLength.setText(seconds + "");});
            }

        }
    }

    private void getDurationInSeconds(File file, Consumer<Integer> onDurationReady) {
        Media media = new Media(file.toURI().toString());
        MediaPlayer tempPlayer = new MediaPlayer(media);

        tempPlayer.setOnReady(() -> {
            int seconds = (int) Math.round(media.getDuration().toSeconds());
            onDurationReady.accept(seconds);
            tempPlayer.dispose();
        });
    }
}