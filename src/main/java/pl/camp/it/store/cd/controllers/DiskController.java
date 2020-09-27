package pl.camp.it.store.cd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.store.cd.model.Artist;
import pl.camp.it.store.cd.model.CoverImage;
import pl.camp.it.store.cd.model.Disk;
import pl.camp.it.store.cd.model.Genre;
import pl.camp.it.store.cd.services.IDiskService;
import pl.camp.it.store.cd.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class DiskController {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IDiskService diskService;

    @RequestMapping(value = "/addDisk", method = RequestMethod.GET)
    public String showAddDiskForm(Model model) {
        model.addAttribute("isAdminLogged", this.sessionObject.getAdmin() != null);
        model.addAttribute("isLogged", this.sessionObject.getUser() != null);
        model.addAttribute("disk", new Disk());
        model.addAttribute("artist", new Artist());
        model.addAttribute("genre", new Genre());
        model.addAttribute("coverImage", new CoverImage());
        return "addDisk";
    }

    @RequestMapping(value = "/addDisk", method = RequestMethod.POST)
    public String addDisk(@ModelAttribute Disk disk, @ModelAttribute Artist artist,
                          @ModelAttribute Genre genre, @ModelAttribute CoverImage coverImage) {
        this.diskService.addDisk(disk, artist, genre, coverImage);
        return "redirect:/main";
    }

    @RequestMapping(value ="/editDisk/{id}", method = RequestMethod.GET)
    public String showEditDiskForm(Model model, @PathVariable int id) {
        Disk disk = this.diskService.getDiskById(id);
        model.addAttribute("isAdminLogged", this.sessionObject.getAdmin() != null);
        model.addAttribute("isLogged", this.sessionObject.getUser() != null);
        model.addAttribute("disk", disk);
        return "editDisk";
    }

    @RequestMapping(value = "/editDisk/{id}", method = RequestMethod.POST)
    public String editDisk(@ModelAttribute Disk disk, @PathVariable int id) {
        this.diskService.updateDisk(disk, id);
        return "redirect:" + this.sessionObject.getLastAddress();
    }
}
