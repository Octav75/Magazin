package com.sda.project.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowcaseController {

    @GetMapping("/showcase")
    public String displayShowcase(){
        return "showcase";
    }

}