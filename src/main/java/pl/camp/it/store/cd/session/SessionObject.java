package pl.camp.it.store.cd.session;

import pl.camp.it.store.cd.model.Disk;
import pl.camp.it.store.cd.model.User;

import java.util.List;

public class SessionObject {
    private User user;
    private String lastAddress;
    private String lastFindPattern;
    private List<Disk> basket;

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

    public String getLastFindPattern() {
        return lastFindPattern;
    }

    public void setLastFindPattern(String lastFindPattern) {
        this.lastFindPattern = lastFindPattern;
    }

    public List<Disk> getBasket() {
        return basket;
    }

    public void setBasket(List<Disk> basket) {
        this.basket = basket;
    }
}
