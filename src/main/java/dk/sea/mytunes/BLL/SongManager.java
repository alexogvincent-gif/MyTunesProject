package dk.sea.mytunes.BLL;

import dk.sea.mytunes.BE.Song;
import dk.sea.mytunes.DAL.ISongDataAccess;
import dk.sea.mytunes.DAL.db.SongDAO_DB;

import java.io.IOException;
import java.util.List;

public class SongManager {

    private SongSearcher songSearcher = new SongSearcher();
    private ISongDataAccess songDAO;

    public SongManager() throws IOException {
        songDAO = new SongDAO_DB();
    }

    //Retrieves all songs from the data access layer (DAL)
    public List<Song> getAllSongs() throws Exception {
        return songDAO.getAllSongs();
    }

    //Adds a new song and returns the created song with its database ID
    public List<Song> searchSongs(String query) throws Exception {
        List<Song> allSongs = getAllSongs();
        List<Song> searchResult = songSearcher.search(allSongs, query);

        return searchResult;
    }

    public Song addSong(Song newSong) throws Exception {
        return songDAO.addSong(newSong);
    }

    public void deleteSong(Song songToBeDeleted) throws Exception {
        songDAO.deleteSong(songToBeDeleted);
    }

    public void updateSong(Song songToBeUpdated) throws Exception {
        songDAO.updateSong(songToBeUpdated);
    }
}
