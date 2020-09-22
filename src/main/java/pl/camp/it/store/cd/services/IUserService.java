package pl.camp.it.store.cd.services;

import pl.camp.it.store.cd.model.Admin;
import pl.camp.it.store.cd.model.User;

public interface IUserService {
    void addUser(User user);
    boolean authenticate(User user);
    boolean registerUser(User user, String password2);
    User getUserByLogin(String login);
    Admin getAdminByLogin(String login);
}
