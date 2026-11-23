package dk.sea.mytunes.BE;

public class Song {

    private int title;
    private String artist;
    private String category;
    private int lenght;


    public Song(int title, String artist, String category,int lenght){
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.lenght = lenght;
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

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getLenght() {
        return lenght;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getTitle() {
        return title;
    }
}
