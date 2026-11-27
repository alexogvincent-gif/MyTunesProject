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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class  MyTunesController implements Initializable {
    @FXML
    private TableView<Song> tblViewSong;

    @FXML
    private TableColumn<Song, String> colTitle;

    @FXML
    private TableColumn<Song, String> colArtist;

    @FXML
    private TableColumn<Song, String> colCategory;

    @FXML
    private TableColumn<Song, Integer> colLength;

    @FXML
    private TextField txtSongTitle, txtArtist;
    @FXML
    private SongModel songModel;

    private MediaPlayer currentPlayer;



    public MyTunesController(){
        try {
        songModel = new SongModel();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colArtist.setCellValueFactory(new PropertyValueFactory<>("artist"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colLength.setCellValueFactory(new PropertyValueFactory<>("length"));

        tblViewSong.setItems(songModel.getObservableSongs());
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
        Song selectedSong = tblViewSong.getSelectionModel().getSelectedItem();
        if (selectedSong != null) {
            try {
                songModel.deleteSong(selectedSong);
            } catch (Exception e) {
                displayError(e);
            }
        }
    }


    public void btnClickUpdateSong(ActionEvent actionEvent) {
        Song  selectedSong = tblViewSong.getSelectionModel().getSelectedItem();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dk/sea/mytunes/UpdateSong.fxml"));
            Parent root = fxmlLoader.load();

            UpdateSongController controller = fxmlLoader.getController();
            controller.setSongModel(songModel);
            controller.setSong(selectedSong);


            Stage stage = new Stage();
            stage.setTitle("Update Song");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (Exception e) {
            displayError(e);
        }
    }

    public void bntClickAddsSongPlaylist(ActionEvent primaryStage) {
//
//        Parent newSong = FXMLLoader.load((Objects.requireNonNull(Main.class.getResource("/dk/sea/mytunes/MyTunes.fxml"))));
//        primaryStage.setTitle("MyTunes");
//        primaryStage.setScene(new Scene(newSong, 995, 724));
//        primaryStage.show();
    }

    public void bntClickRemoveSongPlaylist(ActionEvent actionEvent) {

    }
    @FXML

    public void btnClickPlay(ActionEvent actionEvent) {
        Song selectedSong = tblViewSong.getSelectionModel().getSelectedItem();

        // Displays a message if no song is selected
        if (selectedSong == null) {
            displayError(new Exception("Please select a song first"));
            return;
        }

        // Stop any currently playing song
        if (currentPlayer != null) {
            currentPlayer.stop();
            currentPlayer.dispose();
            currentPlayer = null;
        }

        // Error message if file cannot be found
        try {
            File file = new File(selectedSong.getFilePath());
            if (!file.exists()) {
                displayError(new Exception("File not found: " + selectedSong.getFilePath()));
                return;
            }
            // Creates media and media player with media as param
            Media media = new Media(file.toURI().toString());
            currentPlayer = new MediaPlayer(media);

            currentPlayer.setOnError(() -> {
                displayError(currentPlayer.getError());
            });

            currentPlayer.play();

        } catch (Exception e) {
            displayError(e);
        }
    }

    @FXML
    public void btnClickPause(ActionEvent actionEvent) {
        if (currentPlayer != null && currentPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            currentPlayer.pause();
        }
    }
}
