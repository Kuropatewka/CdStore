package pl.camp.it.store.cd.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.store.cd.dao.IDiskDAO;
import pl.camp.it.store.cd.model.Disk;

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
    public List<Disk> findDisks(String pattern) {
        Session session = sessionFactory.openSession();
        Query<Disk> query = session.createQuery("FROM pl.camp.it.store.cd.model.Disk WHERE title like :title");
        query.setParameter("title", "%" + pattern + "%");
        List<Disk> disks = query.getResultList();
        session.close();
        return disks;
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
