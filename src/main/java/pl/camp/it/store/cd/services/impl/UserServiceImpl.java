package pl.camp.it.store.cd.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.store.cd.dao.IUserDAO;
import pl.camp.it.store.cd.model.User;
import pl.camp.it.store.cd.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

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

    @Override
    public boolean registerUser(User user, String password2) {
        if(!user.getPassword().equals(password2)) {
            return false;
        }

        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        this.userDAO.addUser(user);
        return true;
    }
}
