package com.sda.project;

import com.sda.project.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserService userRepository;

    @Autowired
    public UserController(UserService userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String regUser(){

    return "register";
    }
    @GetMapping("/login")
    public String getUser(){
        userRepository.findById(1l);
        return "login";
    }

    @GetMapping("/")
    public String getIndex() {

        User user= new User();
        user.setName("Paul");
        user.setEmail("2@r.ro");
        userRepository.save(user);
        return "index";

    }




}