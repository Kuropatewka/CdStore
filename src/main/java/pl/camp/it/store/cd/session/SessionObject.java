package pl.camp.it.store.cd.session;

import pl.camp.it.store.cd.filter.DiskFilter;
import pl.camp.it.store.cd.model.Admin;
import pl.camp.it.store.cd.model.Disk;
import pl.camp.it.store.cd.model.User;

import java.util.List;

public class SessionObject {
    private User user;
    private String lastAddress;
    private DiskFilter diskFilter;
    private Admin admin;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLastAddress() {
        return lastAddress;
    }

    public void setLastAddress(String lastAddress) {
        this.lastAddress = lastAddress;
    }

    public DiskFilter getDiskFilter() {
        return diskFilter;
    }

    public void setDiskFilter(DiskFilter diskFilter) {
        this.diskFilter = diskFilter;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
