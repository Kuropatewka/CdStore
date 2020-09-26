package pl.camp.it.store.cd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.store.cd.model.Admin;
import pl.camp.it.store.cd.services.IAdminService;
import pl.camp.it.store.cd.services.IUserService;
import pl.camp.it.store.cd.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class AuthenticationAdminController {

    @Autowired
    IAdminService adminService;

    @Autowired
    IUserService userService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/login-admin", method = RequestMethod.GET)
    public String loginAdminForm(Model model) {
        model.addAttribute("admin", new Admin());

        if(this.sessionObject.getAdmin() == null) {
            model.addAttribute("isAdminLogged", false);
            model.addAttribute("isLogged", false);
            return "login-admin";
        } else {
            return "redirect:/main";
        }
    }

    @RequestMapping(value = "/login-admin", method = RequestMethod.POST)
    public String loginAdmin(@ModelAttribute Admin admin) {

        boolean authenticationResult = this.adminService.authenticate(admin);

        if (authenticationResult) {
            this.sessionObject.setAdmin(this.userService.getAdminByLogin(admin.getLogin()));
            return "redirect:/main";
        } else {
            return "redirect:/login-admin";
        }
    }

    @RequestMapping(value = "/logout-admin", method = RequestMethod.GET)
    public String logoutAdmin() {
        this.sessionObject.setAdmin(null);
        return "redirect:/main";
    }
}

