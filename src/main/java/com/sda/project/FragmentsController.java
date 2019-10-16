package com.sda.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentsController {

    @GetMapping("/fragments")
    public String getHome() {
        return "navbar.html";
    }

//    @GetMapping("/markup")
//    public String markupPage() {
//        return "markup.html";
//    }
//
//    @GetMapping("/params")
//    public String paramsPage() {
//        return "params.html";
//    }

//    @GetMapping("/other")
//    public String otherPage(Model model) {
//        model.addAttribute("data", StudentUtils.buildStudents());
//        return "other.html";
//    }
}