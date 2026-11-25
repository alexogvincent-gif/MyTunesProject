package dk.sea.mytunes.GUI.Model;

import dk.sea.mytunes.BE.Song;
import dk.sea.mytunes.BLL.SongManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class SongModel {

    private FilteredList<Song> filteredList;

    private ObservableList<Song> songsToBeViewed;

    private SongManager songManager;



    public SongModel() throws Exception{
        songManager = new SongManager();
        songsToBeViewed = FXCollections.observableArrayList();
        songsToBeViewed.addAll(songManager.getAllSongs());
        filteredList = new FilteredList<>(songsToBeViewed);
    }
}

    public void addSong(Song newSong) throws Exception {
    Song addedSong = SongManager.addSong(newSong);
    songsToBeViewed.add(addedSong);
}








