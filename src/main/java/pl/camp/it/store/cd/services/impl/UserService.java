package pl.camp.it.store.cd.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.store.cd.dao.IUserDAO;
import pl.camp.it.store.cd.model.User;
import pl.camp.it.store.cd.services.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Override
    public void addUser(User user) {
        this.userDAO.addUser(user);
    }
}
