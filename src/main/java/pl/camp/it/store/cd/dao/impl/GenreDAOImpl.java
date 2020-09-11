package pl.camp.it.store.cd.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.store.cd.dao.IGenreDAO;
import pl.camp.it.store.cd.model.Genre;

import java.util.List;

@Repository
public class GenreDAOImpl implements IGenreDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Genre> findGenres(String pattern) {
        Session session = sessionFactory.openSession();
        Query<Genre> query = session.createQuery("FROM pl.camp.it.store.cd.model.Genre WHERE name like :name");
        query.setParameter("name", "%" + pattern + "%");
        List<Genre> genres = query.getResultList();
        session.close();
        return genres;
    }
}
