package pl.camp.it.store.cd.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.store.cd.dao.IDiskDAO;
import pl.camp.it.store.cd.model.*;
import pl.camp.it.store.cd.services.IAdminService;

@Controller
@RequestMapping("/admin/utils")
public class AdminController {

    @Autowired
    IAdminService adminService;

    @Autowired
    IDiskDAO diskDAO;

    @RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
    public String addAdmin(Model model) {
        Admin admin = new Admin();
        admin.setLogin("admin");
        admin.setPassword(DigestUtils.md5Hex("admin"));
        this.adminService.addAdmin(admin);
        return "redirect:/main";
    }
}
