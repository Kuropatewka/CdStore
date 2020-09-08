package pl.camp.it.store.cd.services;

import pl.camp.it.store.cd.model.Disk;

import java.util.List;

public interface IDiskService {
    void addDisk(Disk disk);
    List<Disk> getAllDisks();
}
