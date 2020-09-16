package pl.camp.it.store.cd.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.store.cd.dao.IDiskDAO;
import pl.camp.it.store.cd.model.Artist;
import pl.camp.it.store.cd.model.Disk;
import pl.camp.it.store.cd.model.Genre;

import java.util.List;

@Repository
public class DiskDAOImpl implements IDiskDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addDisk(Disk disk) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(disk);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<Disk> getAllDisks() {
        Session session = sessionFactory.openSession();
        Query<Disk> query = session.createQuery("FROM pl.camp.it.store.cd.model.Disk");
        List<Disk> disk = query.getResultList();
        session.close();
        return disk;
    }

    @Override
    public List<Disk> getDiskByFilter(String pattern, Genre genre, Artist artist, String year) {
        Session session = sessionFactory.openSession();
        Query<Disk> query = session.createQuery("FROM pl.camp.it.store.cd.model.Disk WHERE title like :title AND genre = :genre AND artist = :artist AND year = :year");
        if (pattern != null) {
            query.setParameter("title", "%" + pattern + "%");
        } else {
            query.setParameter("title", "*");
        }

        if (genre != null) {
            query.setParameter("genre", genre);
        } else {
            query.setParameter("genre", "*");
        }

        if (artist != null) {
            query.setParameter("artist", artist);
        } else {
            query.setParameter("artist", "*");
        }

        if (year != null) {
            query.setParameter("year", year);
        } else {
            query.setParameter("year", "*");
        }

        List<Disk> disks = query.getResultList();
        session.close();
        return disks;
    }

    @Override
    public List<Disk> getDiskByTitlePattern(String pattern) {
        Session session = sessionFactory.openSession();
        Query<Disk> query = session.createQuery("FROM pl.camp.it.store.cd.model.Disk WHERE title like :title");
        query.setParameter("title", "%" + pattern + "%");
        List<Disk> disk = query.getResultList();
        session.close();
        return disk;
    }

    @Override
    public List<Disk> getDiskByYear(String year) {
        Session session = sessionFactory.openSession();
        Query<Disk> query = session.createQuery("FROM pl.camp.it.store.cd.model.Disk WHERE year like :year");
        query.setParameter("year", "%" + year + "%");
        List<Disk> disk = query.getResultList();
        session.close();
        return disk;
    }

    @Override
    public List<Disk> getArtistByPattern(String pattern) {
        Session session = sessionFactory.openSession();
        Query<Disk> query = session.createQuery("FROM pl.camp.it.store.cd.model.Artist WHERE name like :name");
        query.setParameter("name", "%" + pattern + "%");
        List<Disk> disk = query.getResultList();
        session.close();
        return disk;
    }

    @Override
    public List<Disk> getGenreByPattern(String pattern) {
        Session session = sessionFactory.openSession();
        Query<Disk> query = session.createQuery("FROM pl.camp.it.store.cd.model.Artist WHERE name like :name");
        query.setParameter("name", "%" + pattern + "%");
        List<Disk> disk = query.getResultList();
        session.close();
        return disk;
    }

    @Override
    public List<Disk> getDiskByArtistId(int id) {
        Session session = sessionFactory.openSession();
        Query<Disk> query = session.createQuery("FROM pl.camp.it.store.cd.model.Disk WHERE artist_id = :artist");
        query.setParameter("artist", id);
        List<Disk> disks = query.getResultList();
        session.close();
        return disks;
    }

    @Override
    public List<Disk> getDiskByGenreId(int id) {
        Session session = sessionFactory.openSession();
        Query<Disk> query = session.createQuery("FROM pl.camp.it.store.cd.model.Disk WHERE genre_id = :genre");
        query.setParameter("genre", id);
        List<Disk> disks = query.getResultList();
        session.close();
        return disks;
    }

    @Override
    public Disk getDiskById(int id) {
        Session session = sessionFactory.openSession();
        Query<Disk> query = session.createQuery("FROM pl.camp.it.store.cd.model.Disk WHERE id = :id");
        query.setParameter("id", id);
        Disk disk = query.getSingleResult();
        session.close();
        return disk;
    }


}
