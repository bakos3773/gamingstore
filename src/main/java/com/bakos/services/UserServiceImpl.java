package com.bakos.services;

import com.bakos.model.User;
import com.bakos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.insert(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
