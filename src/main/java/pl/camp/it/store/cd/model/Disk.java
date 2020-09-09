package pl.camp.it.store.cd.model;

import javax.persistence.*;

@Entity(name = "tdisk")
public class Disk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private int year;
    @Column(nullable = false)
    private int amount;
    @Column(nullable = false)
    private double price;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Artist artist;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Genre genre;
    @OneToOne(cascade = CascadeType.ALL)
    private Image image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Disk{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", amount=" + amount +
                ", price=" + price +
                ", artist=" + artist +
                ", genre=" + genre +
                '}';
    }
}
