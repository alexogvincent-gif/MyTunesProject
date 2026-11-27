package dk.sea.mytunes.DAL.db;

import dk.sea.mytunes.BE.Song;
import dk.sea.mytunes.DAL.ISongDataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
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
                int length = rs.getInt("Length");
                String filePath = rs.getString("filePath");

                Song song = new Song(id, title, artist, category, length, filePath);  // 2. lav sangen
                songs.add(song);
            }
        }
        return songs;
    }

    @Override
    public Song addSong(Song song) throws Exception {
        String sql = "INSERT INTO Song (title, artist, category, length, filePath) VALUES (?,?,?,?,?)";

        try (Connection conn = dbConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, song.getTitle());
            stmt.setString(2, song.getArtist());
            stmt.setString(3, song.getCategory());
            stmt.setInt(4, song.getLength());
            stmt.setString(5, song.getFilePath());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            Song addedSong = new Song(id, song.getTitle(), song.getArtist(), song.getCategory(), song.getLength(), song.getFilePath());

            return addedSong;
        }
    }

    @Override
    public void updateSong(Song song) throws Exception {
        String sql = "UPDATE Song SET Title = ?, Artist = ?, Category = ?, length = ?, Filepath = ? WHERE id = ?";

        try (Connection conn = dbConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, song.getTitle());
            stmt.setString(2, song.getArtist());
            stmt.setString(3, song.getCategory());
            stmt.setInt(4, song.getLength());
            stmt.setString(5, song.getFilePath());
            stmt.setInt(6, song.getId());

            int rows = stmt.executeUpdate();

            System.out.println("3: rows updated: " + rows);
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

