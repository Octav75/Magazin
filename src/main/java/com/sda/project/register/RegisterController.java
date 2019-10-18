package com.sda.project.register;

import com.sda.project.users.User;
import com.sda.project.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        User u = new User();
        model.addAttribute("user", u);
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(User user) {
        userService.save(user);

        return "index";
    }
}
