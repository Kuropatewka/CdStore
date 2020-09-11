/*
package pl.camp.it.store.cd.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.store.cd.dao.IDiskDAO;
import pl.camp.it.store.cd.model.Disk;
import pl.camp.it.store.cd.services.IBasketService;
import pl.camp.it.store.cd.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BasketServiceImpl implements IBasketService {

    @Autowired
    IDiskDAO diskDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public void addToBasket(int id) {

        Disk disk = this.diskDAO.getDiskById(id);
        List<Disk> basket = this.sessionObject.getBasket();

        boolean isDiskInBasket = this.sessionObject.getBasket().contains(disk);

    }
}
*/
