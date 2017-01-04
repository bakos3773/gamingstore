package com.bakos.services;

import com.bakos.model.Game;
import com.bakos.model.User;
import com.bakos.repositories.UserSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserSearchServiceImpl implements UserSearchService {

    @Autowired
    UserSearchRepository userSearchRepository;

    @Autowired
    GameService gameService;

    @Override
    public List<User> findAll() {
        return userSearchRepository.findAll();
    }

    @Override
    public User findByName(String name) {
        return userSearchRepository.findByName(name);
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(String name, Game game) {
        game.setCreatedDate(new Date());
        gameService.save(game);
        userSearchRepository.update(name, game);
    }
}
