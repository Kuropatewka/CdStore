package pl.camp.it.store.cd.services;
import pl.camp.it.store.cd.model.Admin;
import pl.camp.it.store.cd.model.User;

public interface IAdminService {
    void addAdmin(Admin admin);
    boolean authenticate(Admin admin);
}
