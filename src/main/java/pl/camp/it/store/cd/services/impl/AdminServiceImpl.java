package pl.camp.it.store.cd.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.store.cd.dao.IAdminDAO;
import pl.camp.it.store.cd.model.Admin;
import pl.camp.it.store.cd.model.User;
import pl.camp.it.store.cd.services.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    IAdminDAO adminDAO;

    @Override
    public void addAdmin(Admin admin) {
        this.adminDAO.addAdmin(admin);
    }

    @Override
    public boolean authenticate(Admin admin) {
        Admin adminFromDatabase = this.adminDAO.getAdminByLogin(admin.getLogin());

        if (adminFromDatabase == null) {
            return false;
        }

        if (DigestUtils.md5Hex(admin.getPassword()).equals(adminFromDatabase.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
