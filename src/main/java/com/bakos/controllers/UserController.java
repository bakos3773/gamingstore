package com.bakos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/login")
    public String login(){

        System.out.println("Wszedlem do login");
        return "login";
    }

    @RequestMapping("/userpage")
    public String afterLogin(){

        System.out.println("Wszedlem do userpage");
        return "userpage";
    }
}
