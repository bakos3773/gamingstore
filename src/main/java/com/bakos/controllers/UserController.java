package com.bakos.controllers;

import com.bakos.model.User;
import com.bakos.repositories.UserSearchRepositoryImpl;
import com.bakos.services.UserSearchService;
import com.bakos.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserSearchService userSearchService;

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

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){

        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, BindingResult result){

        System.out.println("Wszedlem do registration after user="+user.getFullName() + " addres="+user.getAddress());

        user.setId(new ObjectId().toString());

//        ApplicationContext ctx = new AnnotationConfigApplicationContext(DataBaseConfiguration.class);
//        MongoOperations  mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
//        mongoOperation.save(user);
        userService.save(user);
//userService.deleteAll();
        findAll();
        return "redirect:/login";
    }

    public void findAll(){

        List<User> userList = userSearchService.findAll();
        for(User all: userList)
            System.out.println(all.getId()+" => "+all.getEmail()+" "+all.getPassword());
    }
}
