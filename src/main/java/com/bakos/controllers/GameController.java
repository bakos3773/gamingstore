package com.bakos.controllers;

import com.bakos.model.Game;
import com.bakos.model.User;
import com.bakos.services.GameService;
import com.bakos.services.UserSearchService;
import com.bakos.services.UserService;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    UserSearchService userSearchService;

    @Autowired
    UserService userService;

    @Autowired
    GameService gameService;


    @RequestMapping("/showUserGame/{id}")
    public String showUserGame(@PathVariable("id")String id, Model model){
        Game game = gameService.findById(id);
        model.addAttribute("game", game);
        User user = userSearchService.findByGamesId(id);

        model.addAttribute("user", user);

        return "showUserGame";
    }

    @RequestMapping(value = "/addGame", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.OK)
//    public String addGame(MultipartFile zdjecie, BindingResult result, Principal principal) throws IOException {
    public String addGame(@RequestParam("picture")MultipartFile image, Game game, BindingResult result, Principal principal) throws IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userSearchService.findByName(auth.getName());

        String nameFIle = game.getName()+"-"+user.getUsername();
        game.setOwner(user.getUsername());
        game.setImageName(nameFIle);
        game.setOwnerId(user.getId());
        userSearchService.addGame(user, game);

        if( !image.isEmpty() ){
            BufferedImage src = ImageIO.read(new ByteArrayInputStream(image.getBytes()));
            String path = File.separator+"home"+File.separator+"bakos3773"+File.separator+"Programming"+File.separator+"intellij"+File.separator+"Files all project"+File.separator+"gamingstoreFiles"+File.separator+"Images"+File.separator+nameFIle;
            File destination = new File(path);
            ImageIO.write(src, "jpg", destination);
        }

        return "userpage";
    }

    @RequestMapping(value = "/image/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName")String imageName) throws IOException {

        System.out.println("JEEEEEEEEEEEEEEst");
        String path = "/home/bakos3773/Programming/intellij/Files all project/gamingstoreFiles/Images/"+imageName;
        File fileFromServer = new File(path);
        return Files.readAllBytes(fileFromServer.toPath());
    }

}
