package com.bakos.controllers;

import com.bakos.model.User;
import com.bakos.services.EmailService;
import com.bakos.services.UserSearchService;
import com.bakos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;

    @Autowired
    UserSearchService userSearchService;

    @RequestMapping("/login")
    public String login(){

        return "login";
    }

    @RequestMapping("/")
    public String greeting(Model model){

        model.addAttribute("hello", "Jestem z kontrollwera :)");
        return"index";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){

        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, BindingResult result){

        user.setConfirmationId(createConfirmationID());
        emailService.send(user.getEmail(), "Gamestore Account confirmation Link",
                "http://localhost:8080/confirm?id="+user.getConfirmationId());

        userService.save(user);
        return "redirect:/login";
    }
    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String getting(@RequestParam(value = "id", required = true) String confirmationId, Model model ){

        System.out.println("Wszedlem do srodka Confirm");
        User user = userService.getUserByConfirmationId(confirmationId);
        String message = "Invalid confirmation id. Contact us or try again.";
        if(user!=null){
            if(!user.isConfirmationStatus()){
                user.setConfirmationStatus(true);
                user.setConfirmationId(null);
                userSearchService.update(user);
            }
            message = user.getUsername()+" "+ user.getSurname() +", your account has been verified. You may now log in. ";
        }

        model.addAttribute("message", message);
        return "message";
    }

    private String createConfirmationID(){
        return java.util.UUID.randomUUID().toString();
    }

}
