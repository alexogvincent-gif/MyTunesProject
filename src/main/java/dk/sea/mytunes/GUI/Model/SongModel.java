package dk.sea.mytunes.GUI.Model;

import dk.sea.mytunes.BE.Song;
import dk.sea.mytunes.BLL.SongManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.util.List;

public class SongModel {

    private FilteredList<Song> filteredList;

    private ObservableList<Song> songsToBeViewed;

    private SongManager songManager;


    public SongModel() throws Exception {
        songManager = new SongManager();
        songsToBeViewed = FXCollections.observableArrayList();
        songsToBeViewed.addAll(songManager.getAllSongs());
        filteredList = new FilteredList<>(songsToBeViewed);
    }

    public ObservableList<Song> getSongsToBeViewed(){
        return songsToBeViewed;
    }


    public ObservableList<Song> getObservableSongs() {
        return filteredList;
    }

    public void addSong(Song newSong) throws Exception {
        Song addedSong = songManager.addSong(newSong);
        songsToBeViewed.add(addedSong);
    }

    public void deleteSong(Song songToBeDeleted) throws Exception {
        songManager.deleteSong(songToBeDeleted);
        songsToBeViewed.remove(songToBeDeleted);
    }

    public void updateSong(Song songTobeUpdated) throws Exception {
        System.out.println("2: model, title = " +  songTobeUpdated.getTitle());
        songManager.updateSong(songTobeUpdated);

        for (int i = 0; i < songsToBeViewed.size(); i++) {
            if (songsToBeViewed.get(i).getId() == songTobeUpdated.getId()) {
                songsToBeViewed.set(i, songTobeUpdated);
                break;
            }
        }
    }
}








