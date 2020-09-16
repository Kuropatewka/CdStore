package pl.camp.it.store.cd.dao;

import pl.camp.it.store.cd.model.Artist;
import pl.camp.it.store.cd.model.Disk;
import pl.camp.it.store.cd.model.Genre;

import java.util.List;

public interface IDiskDAO {
    void addDisk(Disk disk);
    List<Disk> getAllDisks();
    List<Disk> getDiskByFilter(String pattern, Genre genre, Artist artist, String year);
    List<Disk> getDiskByTitlePattern(String pattern);
    List<Disk> getDiskByYear(String year);
    List<Disk> getArtistByPattern(String year);
    List<Disk> getGenreByPattern(String year);
    List<Disk> getDiskByArtistId(int id);
    List<Disk> getDiskByGenreId(int id);
    Disk getDiskById(int id);
}
