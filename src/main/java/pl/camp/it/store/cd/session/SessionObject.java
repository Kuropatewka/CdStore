package pl.camp.it.store.cd.session;

import pl.camp.it.store.cd.model.User;

public class SessionObject {
    private User user;
    private String lastAddress;

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
}
