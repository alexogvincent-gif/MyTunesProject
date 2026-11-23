package dk.sea.mytunes.BE;

public class Song {

    private int title;
    private String artist;
    private String category;
    private int length;


    public Song(int title, String artist, String category,int length){
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.length = length;
    }

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

    public void setTitle(int title) {
        this.title = title;
    }

    public int getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title=" + title +
                ", artist='" + artist + '\'' +
                ", category='" + category + '\'' +
                ", length=" + length +
                '}';
    }
}
