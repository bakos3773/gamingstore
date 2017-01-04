package com.bakos.controllers;

import com.bakos.model.Game;
import com.bakos.model.User;
import com.bakos.services.GameService;
import com.bakos.services.UserSearchService;
import com.bakos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    GameService gameService;

    @Autowired
    UserSearchService userSearchService;

    @RequestMapping("/login")
    public String login(){

        System.out.println("Wszedlem do login");
        return "login";
    }

    @RequestMapping("/userpage")
    public String afterLogin(Model model){

        model.addAttribute("game", new Game());
        return "userpage";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){

        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, BindingResult result){

        System.out.println("Wszedlem do registration after user="+user.getFullName() + " addres="+user.getAddress());

        userService.save(user);
        return "redirect:/login";
    }

    public void findAll(){
        List<User> userList = userSearchService.findAll();
        for(User all: userList)
            System.out.println(all.getId()+" => "+all.getEmail()+" "+all.getPassword());
    }

    @RequestMapping(value = "/addGame", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String addGame(@ModelAttribute("game") Game game, BindingResult result, Principal principal){


        userSearchService.update("Ala", game);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
//        findAll();

        return "userpage";
    }

    @RequestMapping("/getAllUsersGame")
    @ResponseBody
    public ResponseEntity<List<Game>> getAllUsersGame(){

        List<Game> games = gameService.findAll();

        return new ResponseEntity<List<Game>>(games, HttpStatus.OK);
    }
}
