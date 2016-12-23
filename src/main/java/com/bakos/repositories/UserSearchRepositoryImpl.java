package com.bakos.repositories;

import com.bakos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserSearchRepositoryImpl implements UserSearchRepository{

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }
}
