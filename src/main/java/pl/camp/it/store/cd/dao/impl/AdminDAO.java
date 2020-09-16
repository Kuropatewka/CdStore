package pl.camp.it.store.cd.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.store.cd.dao.IAdminDAO;
import pl.camp.it.store.cd.model.Admin;

@Repository
public class AdminDAO implements IAdminDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addAdmin(Admin admin) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(admin);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}
