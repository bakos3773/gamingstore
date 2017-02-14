package com.bakos.services;

import com.bakos.model.Game;

import java.util.List;

/**
 * Created by Bakos on 2016-12-27.
 */
public interface GameService {
    public void save(Game game);
    public List<Game> findAll();
    public Game findById(String id);
}
