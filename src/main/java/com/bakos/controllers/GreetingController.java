package com.bakos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {


    @RequestMapping("/")
    public String greeting(Model model){

        model.addAttribute("hello", "Jestem z kontrollwera :)");
        return"index";
    }

    @RequestMapping("/greeting")
    @ResponseBody
    public String hello() {
        return "Greetings from Spring Boot!";
    }
}
