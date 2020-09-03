package pl.camp.it.store.cd.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
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

    @Override
    public boolean authenticate(User user) {
        User userFromDatabase = this.userDAO.getUserByLogin(user.getLogin());

        if(userFromDatabase == null) {
            return false;
        }

        if (DigestUtils.md5Hex(user.getPassword()).equals(userFromDatabase.getPassword())) {
            return true;
        } else {
            return false;
        }

    }
}