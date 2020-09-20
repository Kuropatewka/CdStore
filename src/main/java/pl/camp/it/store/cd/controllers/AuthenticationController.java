package pl.camp.it.store.cd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.store.cd.model.Admin;
import pl.camp.it.store.cd.model.User;
import pl.camp.it.store.cd.services.IAdminService;
import pl.camp.it.store.cd.services.IUserService;
import pl.camp.it.store.cd.session.SessionObject;
import pl.camp.it.store.cd.utils.Converters;

import javax.annotation.Resource;

@Controller
public class AuthenticationController {

    @Autowired
    IUserService userService;

    @Autowired
    IAdminService adminService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("user", new User());

        if(this.sessionObject.getUser() == null) {
            model.addAttribute("isLogged", false);
            return "login";
        } else {
            return "redirect:main";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user) {
        boolean authenticationResult = this.userService.authenticate(user);

        Admin admin = Converters.convertUserToAdmin(user);
        boolean authenticationAdminResult = this.adminService.authenticate(admin);

        if(authenticationAdminResult) {
            this.sessionObject.setAdmin(admin);
        }

        if(authenticationResult) {
            this.sessionObject.setUser(user);
        }

        if (authenticationResult || authenticationAdminResult) {
            return "redirect:/main";
        } else {
            return "redirect:/login";
        }
    }
}
