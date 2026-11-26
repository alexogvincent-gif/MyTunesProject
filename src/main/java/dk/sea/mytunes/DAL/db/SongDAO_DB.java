package dk.sea.mytunes.DAL.db;

import dk.sea.mytunes.BE.Song;
import dk.sea.mytunes.DAL.ISongDataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;


public class SongDAO_DB implements ISongDataAccess {

    private DBConnector dbConnector = new DBConnector();

    public SongDAO_DB() throws IOException {

    }


    @Override
    public List<Song> getAllSongs() throws Exception {
        List<Song> songs = new ArrayList<>();

        try (Connection conn = dbConnector.getConnection()) {
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM Song";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("Id");
                String title = rs.getString("Title");
                String artist = rs.getString("Artist");
                String category = rs.getString("Category");
                int duration = rs.getInt("Duration");
                String filePath = rs.getString("filePath");


            }
        }
        return songs;
    }

    @Override
    public Song addSong(Song song) throws Exception {
        String sql = "INSERT INTO Song (title, artist, category, duration, filePath) VALUES (?,?,?,?,?)";

        try (Connection conn = dbConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, song.getTitle());
            stmt.setString(2, song.getArtist());
            stmt.setString(3, song.getCategory());
            stmt.setInt(4, song.getDuration());
            stmt.setString(5, song.getFilePath());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            Song addedSong = new Song(id, song.getTitle(), song.getArtist(), song.getCategory(), song.getDuration(), song.getFilePath());

            return addedSong;
        }
    }

    @Override
    public void updateSong(Song song) throws Exception {
        String sql = "UPDATE Song SET Title = ?, Artist = ?, Category = ?, duration = ? WHERE id = ?";

        try (Connection conn = dbConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, song.getTitle());
            stmt.setString(2, song.getArtist());
            stmt.setString(3, song.getCategory());
            stmt.setInt(4, song.getDuration());
            stmt.setInt(5, song.getId());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteSong(Song song) throws Exception {
        String sql = "DELETE FROM Song WHERE id = ?";

        try (Connection conn = dbConnector.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, song.getId());

            stmt.executeUpdate();
        }
    }
}

