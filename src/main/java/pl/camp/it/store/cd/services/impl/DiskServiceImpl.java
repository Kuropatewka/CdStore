package pl.camp.it.store.cd.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.store.cd.dao.IDiskDAO;
import pl.camp.it.store.cd.filter.DiskFilter;
import pl.camp.it.store.cd.model.Artist;
import pl.camp.it.store.cd.model.Disk;
import pl.camp.it.store.cd.model.Genre;
import pl.camp.it.store.cd.model.User;
import pl.camp.it.store.cd.services.IDiskService;
import pl.camp.it.store.cd.session.SessionObject;

import javax.annotation.Resource;
import java.util.*;

@Service
public class DiskServiceImpl implements IDiskService {

    @Autowired
    IDiskDAO diskDAO;

    @Override
    public void addDisk(Disk disk) {
        this.diskDAO.addDisk(disk);
    }

    @Override
    public List<Disk> getAllDisks() {
        return this.diskDAO.getAllDisks();
    }

    @Override
    public List<Disk> findDiskByYear(String year) {
        return this.diskDAO.getDiskByYear(year);
    }

    @Override
    public List<Disk> findDiskByPattern(String pattern) {
        Set<Disk> result = new HashSet<>();
        List<Disk> disks = this.diskDAO.getDiskByPattern(pattern);

        result.addAll(disks);

        List<Artist> artists = this.diskDAO.getArtistByPattern(pattern);
        for (Artist artist : artists) {
            List<Disk> diskForArtist = this.diskDAO.getDiskByArtistId(artist.getId());

            result.addAll(diskForArtist);
        }

        List<Genre> genres = this.diskDAO.getGenreByPattern(pattern);
        for (Genre genre : genres) {
            List<Disk> diskForGenre = this.diskDAO.getDiskByGenreId(genre.getId());

            result.addAll(diskForGenre);
        }
        return new ArrayList<>(result);
    }

    @Override
    public List<Disk> findDiskByPatternAndYear(String pattern, String year) {
        Set<Disk> result = new HashSet<>();

        for (Disk disk : findDiskByPattern(pattern)) {
            if (disk.getYear().equals(year)) {
                result.add(disk);
            }
        }
        return new ArrayList<>(result);
    }


    @Override
    public List<Disk> findDiskByFilter(DiskFilter diskFilter) {

        String pattern = diskFilter.getLastFindPattern();
        String year = diskFilter.getYear();

        //pattern
        if(pattern != null && year == null) {
            return findDiskByPattern(pattern);
        }

        //year
        if(pattern == null && year != null) {
            return findDiskByYear(year);
        }

        //pattern & year
        if(pattern != null && year != null) {
            return findDiskByPatternAndYear(pattern, year);
        }

        return new ArrayList<>();
    }
}