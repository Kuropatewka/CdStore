package pl.camp.it.store.cd.dao;

import pl.camp.it.store.cd.model.Artist;
import pl.camp.it.store.cd.model.Disk;
import pl.camp.it.store.cd.model.Genre;

import java.util.List;

public interface IDiskDAO {
    void addDisk(Disk disk);
    void updateDisk(Disk disk);
    List<Disk> getAllDisks();
    List<Disk> getDiskByFilter(String pattern, String year);
    List<Disk> getDiskByPattern(String pattern);
    List<Disk> getDiskByYear(String year);
    List<Artist> getArtistByPattern(String pattern);
    List<Genre> getGenreByPattern(String pattern);
    List<Disk> getDiskByArtistId(int id);
    List<Disk> getDiskByGenreId(int id);
    Disk getDiskById(int id);
    List<Artist> getAllArtists();
    List<Genre> getAllGenres();
    Artist getArtistByName(String name);
    Genre getGenreByName(String type);
}
