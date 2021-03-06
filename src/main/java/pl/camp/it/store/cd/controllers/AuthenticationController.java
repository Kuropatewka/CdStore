package pl.camp.it.store.cd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.store.cd.model.User;
import pl.camp.it.store.cd.services.IUserService;
import pl.camp.it.store.cd.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class AuthenticationController {

    @Autowired
    IUserService userService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("user", new User());

        if(this.sessionObject.getUser() == null) {
            model.addAttribute("isLogged", false);
            model.addAttribute("isAdminLogged", false);
            return "login";
        } else {
            return "redirect:/main";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user) {

        boolean authenticationResult = this.userService.authenticate(user);

        if (authenticationResult) {
            this.sessionObject.setUser(this.userService.getUserByLogin(user.getLogin()));
            return "redirect:/main";
        } else {
            return "redirect:/login";
        }
    }
}
