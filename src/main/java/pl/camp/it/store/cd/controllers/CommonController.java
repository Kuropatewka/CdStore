package pl.camp.it.store.cd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.camp.it.store.cd.model.Disk;
import pl.camp.it.store.cd.services.IDiskService;
import pl.camp.it.store.cd.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CommonController {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IDiskService diskService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultRedirect() {
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("isLogged", sessionObject.getUser() != null);
        List<Disk> disks = this.diskService.getAllDisks();
        model.addAttribute("disks", disks);
        this.sessionObject.setLastAddress("/main");
        return "main";
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String findDisks(Model model, @RequestParam String pattern) {
        model.addAttribute("isLogged", sessionObject.getUser() != null);
        List<Disk> disks = this.diskService.findDisks(pattern);
        this.sessionObject.setLastFindPattern(pattern);
        model.addAttribute("disks", disks);
        this.sessionObject.setLastAddress("/find");
        return "main";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findDisksAfterRedirect(Model model) {
        model.addAttribute("isLogged", sessionObject.getUser() != null);
        List<Disk> disks = this.diskService.findDisks(sessionObject.getLastFindPattern());
        model.addAttribute("disks", disks);
        this.sessionObject.setLastAddress("/find");
        return "main";
    }
}
