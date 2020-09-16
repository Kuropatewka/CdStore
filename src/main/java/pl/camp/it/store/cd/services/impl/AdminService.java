package pl.camp.it.store.cd.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.store.cd.dao.IAdminDAO;
import pl.camp.it.store.cd.model.Admin;
import pl.camp.it.store.cd.services.IAdminService;

@Service
public class AdminService implements IAdminService {

    @Autowired
    IAdminDAO adminDAO;


    @Override
    public void addAdmin(Admin admin) {
        this.adminDAO.addAdmin(admin);
    }
}
