package com.bakos.controllers;

import com.bakos.model.Friend;
import com.bakos.model.Game;
import com.bakos.model.User;
import com.bakos.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    GameService gameService;

    @Autowired
    FriendService friendService;

    @Autowired
    UserSearchService userSearchService;

    @Autowired
    EmailService emailService;


    @RequestMapping("/userpage")
    public String afterLogin(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Friend> friends = userSearchService.findByName(auth.getName()).getFriends();
        model.addAttribute("friends", friends);
        model.addAttribute("game", new Game());
        return "userpage";
    }

    @RequestMapping(value = "/getAllFriends", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Friend>> getAllFriends(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Friend> friends = userSearchService.findByName(auth.getName()).getFriends();

        return new ResponseEntity<List<Friend>>(friends, HttpStatus.OK);
    }

    public void findAll(){
        List<User> userList = userSearchService.findAll();
        for(User all: userList)
            System.out.println(all.getId()+" => "+all.getEmail()+" "+all.getPassword());
    }



    @RequestMapping("/getAllUsersGame")
    @ResponseBody
    public ResponseEntity<List<Game>> getAllUsersGame(){

        List<Game> games = gameService.findAll();

        return new ResponseEntity<List<Game>>(games, HttpStatus.OK);
    }

    @RequestMapping("/adminPanel")
    public String adminPanel(){

        return "adminPanel";
    }

    @RequestMapping("/showUser/{id}")
    public String showUser(@PathVariable("id")String id, Model model){

        User user = userService.findById(id);
        List<Game> allUserGames = user.getGames();
        model.addAttribute("user", user);
        model.addAttribute("games", allUserGames);
        return "showUser";
    }

    @RequestMapping("/addFriend/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addFriend(@PathVariable("id")String id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userSearchService.findByName(auth.getName());
        User temp = userService.findById(id);
        Friend friend = new Friend(temp.getId(), temp.getUsername(), temp.getSurname());
        friendService.save(friend);
        user.getFriends().add(friend);
        userSearchService.update(user);
    }
}
