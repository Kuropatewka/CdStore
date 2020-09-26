package pl.camp.it.store.cd.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.store.cd.dao.IDiskDAO;
import pl.camp.it.store.cd.filter.DiskFilter;
import pl.camp.it.store.cd.model.Artist;
import pl.camp.it.store.cd.model.CoverImage;
import pl.camp.it.store.cd.model.Disk;
import pl.camp.it.store.cd.model.Genre;
import pl.camp.it.store.cd.services.IDiskService;

import java.util.*;

@Service
public class DiskServiceImpl implements IDiskService {

    @Autowired
    IDiskDAO diskDAO;

    @Override
    public void addDisk(Disk disk, Artist artist, Genre genre, CoverImage coverImage) {

        if(artistInDb(artist)) {
            disk.setArtist(this.diskDAO.getArtistByName(artist.getName()));
        } else {
            disk.setArtist(artist);
        }

        if(genreInDb(genre)) {
            disk.setGenre(this.diskDAO.getGenreByName(genre.getName()));
        } else {
            disk.setGenre(genre);
        }
        disk.setCoverImage(coverImage);
        this.diskDAO.addDisk(disk);
    }

    @Override
    public List<Disk> getAllDisks() {
        return this.diskDAO.getAllDisks();
    }

    @Override
    public boolean artistInDb(Artist artist) {

        for(Artist tempArtist : this.diskDAO.getAllArtists()) {
            if(tempArtist.getName().equals(artist.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean genreInDb(Genre genre) {

        for(Genre tempGenre : this.diskDAO.getAllGenres()) {
            if(tempGenre.getName().equals(genre.getName())) {
                return true;
            }
        }
        return false;
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