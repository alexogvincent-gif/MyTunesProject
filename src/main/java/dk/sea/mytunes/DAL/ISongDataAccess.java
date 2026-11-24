package dk.sea.mytunes.DAL;

import dk.sea.mytunes.BE.Song;

import java.util.List;

public interface ISongDataAccess {

    List<Song> getAllSongs() throws Exception;

    Song addSong(Song newSong) throws Exception;

    void updateSong(Song song) throws Exception;

    void deleteSong(Song song) throws Exception;

}
