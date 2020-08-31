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
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Artist artist;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Genre genre;

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

    @Override
    public String toString() {
        return "Disk{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", artist=" + artist +
                ", genre=" + genre +
                '}';
    }
}
