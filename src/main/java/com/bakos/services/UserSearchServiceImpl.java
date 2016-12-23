package com.bakos.services;

import com.bakos.model.User;
import com.bakos.repositories.UserSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSearchServiceImpl implements UserSearchService {

    @Autowired
    UserSearchRepository userSearchRepository;

    @Override
    public List<User> findAll() {
        return userSearchRepository.findAll();
    }
}
