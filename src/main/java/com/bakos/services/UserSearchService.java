package com.bakos.services;

import com.bakos.model.Game;
import com.bakos.model.User;

import java.util.List;

public interface UserSearchService {

    public List<User> findAll();
    public User findByName(String name);
    public void save(User user);
    public void addGame(User user, Game game);
    public void update(User user);
    public User findByGamesId(String id);
}
