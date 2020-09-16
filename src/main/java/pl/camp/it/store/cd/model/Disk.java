package pl.camp.it.store.cd.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "tdisk")
public class Disk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String year;
    @Column(nullable = false)
    private int amount;
    @Column(nullable = false)
    private double price;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Artist artist;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Genre genre;
    @OneToOne(cascade = CascadeType.ALL)
    private CoverImage coverImage;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
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

    public CoverImage getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(CoverImage coverImage) {
        this.coverImage = coverImage;
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

    @Override
    public int hashCode() {
        return this.id;
    }
}
