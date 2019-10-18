package com.sda.project.register;

import com.sda.project.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showSignUpForm(User user) {
        return "register";
    }
}
