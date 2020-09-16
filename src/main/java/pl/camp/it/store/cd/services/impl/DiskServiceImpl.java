/*
package pl.camp.it.store.cd.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.store.cd.dao.IArtistDAO;
import pl.camp.it.store.cd.dao.IDiskDAO;
import pl.camp.it.store.cd.dao.IGenreDAO;
import pl.camp.it.store.cd.filter.DiskFilter;
import pl.camp.it.store.cd.model.Artist;
import pl.camp.it.store.cd.model.Disk;
import pl.camp.it.store.cd.model.Genre;
import pl.camp.it.store.cd.services.IDiskService;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DiskServiceImpl implements IDiskService {

    @Autowired
    IDiskDAO diskDAO;

    @Autowired
    IArtistDAO artistDAO;

    @Autowired
    IGenreDAO genreDAO;

    @Override
    public void addDisk(Disk disk) {
        this.diskDAO.addDisk(disk);
    }

    @Override
    public List<Disk> getAllDisks() {
       return this.diskDAO.getAllDisks();
    }

    @Override
    public List<Disk> getDiskByFilter(DiskFilter diskFilter) {
        Set<Disk> result = new HashSet<>();

        List<Disk> disks = this.diskDAO.getDiskByFilter(pattern, genre, artist, year);

        result.addAll(disks);

        List<Artist> artists = this.artistDAO.findArtists(pattern);
        for(Artist artist : artists) {
            List<Disk> diskForArtist = this.diskDAO.getDiskByArtistId(artist.getId());

            result.addAll(diskForArtist);
        }

        List<Genre> genres = this.genreDAO.findGenres(pattern);
        for(Genre genre : genres) {
            List<Disk> diskForGenres = this.diskDAO.getDiskByGenreId(genre.getId());

            result.addAll(diskForGenres);
        }

        return new ArrayList<>(result);
    }

}
*/
