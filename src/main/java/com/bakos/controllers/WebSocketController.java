package com.bakos.controllers;

import com.bakos.model.*;
import com.bakos.services.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate template;


    @MessageMapping("/hello")
    @SendTo("/queue/test")
    public void chatMessage(@Payload ChatMessage message, Principal principal) throws Exception {


        String userName = principal.getName();
        message.setSender(userName);
        String recipient = message.getRecipient();
        System.out.println("Wszedlem recipient="+recipient);

        if( !userName.equals(recipient) ){
            template.convertAndSendToUser(userName, "/queue/test", message);
        }
            template.convertAndSendToUser(recipient, "/queue/test", message);

    }


}
