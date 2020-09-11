package pl.camp.it.store.cd.dao;

import pl.camp.it.store.cd.model.Genre;

import java.util.List;

public interface IGenreDAO {
    List<Genre> findGenres(String pattern);
}
