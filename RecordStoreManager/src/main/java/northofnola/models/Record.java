package northofnola.models;

public class Record {
    private String title;
    private String artist;
    private double price;

    public Record(String title, String artist, double price) {
        this.title = title;
        this.artist = artist;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getPrice() {
        return price;
    }
}

