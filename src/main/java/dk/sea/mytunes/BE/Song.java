package dk.sea.mytunes.BE;

public class Song {

    private int id;
    private String title;
    private String artist;
    private String category;
    private int length;
    private String filePath;


    public Song(int id, String title, String artist, String category, int length, String filePath) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.length = length;
        this.filePath = filePath;
    }

    public int getId() { return id; }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist(){
        return artist;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() { return title; }

    public String getFilePath() { return filePath; }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", category='" + category + '\'' +
                ", duration=" + length +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
