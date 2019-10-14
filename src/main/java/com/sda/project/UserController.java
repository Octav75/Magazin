package com.sda.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String getIndex() {

        User one= new User();
        one.setName("Paul");
        one.setEmail("2@r.ro");
        userRepository.save(one);
        return "index";
    }


}