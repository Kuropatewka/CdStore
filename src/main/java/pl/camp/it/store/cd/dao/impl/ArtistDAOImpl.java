package pl.camp.it.store.cd.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.store.cd.dao.IArtistDAO;
import pl.camp.it.store.cd.model.Artist;

import java.util.List;

@Repository
public class ArtistDAOImpl implements IArtistDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<Artist> findArtists(String pattern) {
        Session session = sessionFactory.openSession();
        Query<Artist> query = session.createQuery("FROM pl.camp.it.store.cd.model.Artist WHERE name like :name");
        query.setParameter("name", "%" + pattern + "%");
        List<Artist> artists = query.getResultList();
        session.close();
        return artists;
    }
}
