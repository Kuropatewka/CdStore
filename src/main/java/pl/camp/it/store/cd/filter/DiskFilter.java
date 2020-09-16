package pl.camp.it.store.cd.filter;

import pl.camp.it.store.cd.model.Artist;
import pl.camp.it.store.cd.model.Genre;

public class DiskFilter {
    private String lastFindPattern;
    private Genre genre;
    private Artist artist;
    private String year;

    public String getLastFindPattern() {
        return lastFindPattern;
    }

    public void setLastFindPattern(String lastFindPattern) {
        this.lastFindPattern = lastFindPattern;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void reset() {
        this.artist = null;
        this.genre = null;
        this.lastFindPattern = null;
        this.year = null;
    }

    @Override
    public String toString() {
        return "DiskFilter{" +
                "lastFindPattern='" + lastFindPattern + '\'' +
                ", genre=" + genre +
                ", artist=" + artist +
                ", year='" + year + '\'' +
                '}';
    }
}
