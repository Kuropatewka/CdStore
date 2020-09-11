package pl.camp.it.store.cd.dao;

import pl.camp.it.store.cd.model.Artist;

import java.util.List;

public interface IArtistDAO {
    List<Artist> findArtists(String pattern);
}
