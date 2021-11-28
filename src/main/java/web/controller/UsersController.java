package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;

@Controller
@RequestMapping("/user")
public class UsersController {

    private final UserDetailsService userDetailsService;

    @Autowired
    public UsersController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping()
    public String showUser(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("currentUser",
                userDetailsService.loadUserByUsername(currentUser.getUsername()));
        return "user/user_info";
    }
}
