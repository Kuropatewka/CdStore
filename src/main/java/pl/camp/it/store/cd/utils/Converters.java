package pl.camp.it.store.cd.utils;

import pl.camp.it.store.cd.model.Admin;
import pl.camp.it.store.cd.model.User;

public class Converters {

    public static Admin convertAdminToUser(User user) {
        Admin admin = new Admin();
        admin.setLogin(user.getLogin());
        admin.setPassword(user.getPassword());
        return admin;
    }
}
