package com.bakos.controllers;

import com.bakos.model.User;
import com.bakos.services.UserSearchService;
import com.bakos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/user")
public class UserRestController {

    @Autowired
    UserSearchService userSearchService;

    @RequestMapping(value = "/getInfoProfile", method = RequestMethod.GET)
    public ResponseEntity<User> getInfoProfile(Principal principal){

        User me = userSearchService.findByName(principal.getName());

        return new ResponseEntity<User>(me, HttpStatus.OK);
    }
}
