package dk.sea.mytunes.BE;

public class Song {

    private int id;
    private String title;
    private String artist;
    private String category;
    private int duration;
    private String filePath;


    public Song(int id, String title, String artist, String category,int duration, String filePath) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.duration = duration;
        this.filePath = filePath;
    }

    public int getId() { return id; }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public static String getArtist(){
        return artist;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static String getTitle() { return title; }

    public String getFilePath() { return filePath; }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", category='" + category + '\'' +
                ", duration=" + duration +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
