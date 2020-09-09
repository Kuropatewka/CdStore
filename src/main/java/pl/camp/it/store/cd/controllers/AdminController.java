package pl.camp.it.store.cd.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.store.cd.dao.IDiskDAO;
import pl.camp.it.store.cd.model.*;
import pl.camp.it.store.cd.services.IUserService;

import java.net.URL;

@Controller
@RequestMapping("/admin/utils")
public class AdminController {

    @Autowired
    IUserService userService;

    @Autowired
    IDiskDAO diskDAO;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        User user = new User();
        user.setLogin("admin");
        user.setPassword(DigestUtils.md5Hex("admin"));
        this.userService.addUser(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/addDisks", method = RequestMethod.GET)
    public String addDisk() {

        Disk disk = new Disk();
        disk.setTitle("Lost Forever, Lost Together");
        disk.setYear(2014);
        disk.setAmount(3);
        disk.setPrice(39.99);

        Artist artist = new Artist();
        artist.setName("Architects");

        Genre genre = new Genre();
        genre.setName("Metalcore");

        disk.setArtist(artist);
        disk.setGenre(genre);

        Disk disk2 = new Disk();
        disk2.setTitle("Holy Hell");
        disk2.setYear(2018);
        disk2.setAmount(7);
        disk2.setPrice(59.99);

        disk2.setArtist(artist);
        disk2.setGenre(genre);

        Disk disk3 = new Disk();
        disk3.setTitle("All Our Gods Have Abandoned Us");
        disk3.setYear(2016);
        disk3.setAmount(2);
        disk3.setPrice(49.99);

        disk3.setArtist(artist);
        disk3.setGenre(genre);

        Disk disk4 = new Disk();
        disk4.setTitle("Periphery IV: Hail Stan");
        disk4.setYear(2019);
        disk4.setAmount(8);
        disk4.setPrice(34.99);

        Artist artist2 = new Artist();
        artist2.setName("Periphery");

        Genre genre2 = new Genre();
        genre2.setName("Djent");

        disk4.setArtist(artist2);
        disk4.setGenre(genre2);

        Disk disk5 = new Disk();
        disk5.setTitle("Anticult");
        disk5.setYear(2017);
        disk5.setAmount(2);
        disk5.setPrice(24.99);

        Artist artist3 = new Artist();
        artist3.setName("Decapitated");

        Genre genre3 = new Genre();
        genre3.setName("Deathmetal");

        disk5.setArtist(artist3);
        disk5.setGenre(genre3);

        this.diskDAO.addDisk(disk);
        this.diskDAO.addDisk(disk2);
        this.diskDAO.addDisk(disk3);
        this.diskDAO.addDisk(disk4);
        this.diskDAO.addDisk(disk5);

        return "redirect:/main";
    }
}
