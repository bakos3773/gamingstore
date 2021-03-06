package com.bakos.repositories;


import com.bakos.model.Game;
import com.bakos.model.User;

import java.security.Principal;
import java.util.List;

public interface UserSearchRepository {

    public List<User> findAll();
    public User findByName(String name);
    public void save(User user);
    public void addGame(User user, Game game);
    public void update(User user);
    public User findByGamesId(String id);
}
