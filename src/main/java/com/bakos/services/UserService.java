package com.bakos.services;

import com.bakos.model.User;

import java.util.List;


public interface UserService {

    public void save(User user);
    public List<User> findAll();
    public void deleteAll();
}
