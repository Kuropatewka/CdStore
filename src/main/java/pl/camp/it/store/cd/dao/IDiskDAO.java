package pl.camp.it.store.cd.dao;

import pl.camp.it.store.cd.model.Disk;

import java.util.List;

public interface IDiskDAO {
    void addDisk(Disk disk);
    List<Disk> getAllDisks();
}
