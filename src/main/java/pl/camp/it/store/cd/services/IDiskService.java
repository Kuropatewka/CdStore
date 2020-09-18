package pl.camp.it.store.cd.services;

import pl.camp.it.store.cd.filter.DiskFilter;
import pl.camp.it.store.cd.model.Artist;
import pl.camp.it.store.cd.model.Disk;
import pl.camp.it.store.cd.model.Genre;

import java.util.List;

public interface IDiskService {
    void addDisk(Disk disk);
    List<Disk> getAllDisks();
    List<Disk> findDiskByYear(String year);
    List<Disk> findDiskByPattern(String pattern);
    List<Disk> findDiskByPatternAndYear(String pattern, String year);
    List<Disk> findDiskByFilter(DiskFilter diskFilter);
}
