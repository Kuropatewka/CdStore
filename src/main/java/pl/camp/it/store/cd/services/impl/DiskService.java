package pl.camp.it.store.cd.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.store.cd.dao.IDiskDAO;
import pl.camp.it.store.cd.model.Disk;
import pl.camp.it.store.cd.services.IDiskService;

import java.util.List;

@Service
public class DiskService implements IDiskService {

    @Autowired
    IDiskDAO diskDAO;

    @Override
    public void addDisk(Disk disk) {
        this.diskDAO.addDisk(disk);
    }

    @Override
    public List<Disk> getAllDisks() {
       return this.diskDAO.getAllDisks();
    }
}
