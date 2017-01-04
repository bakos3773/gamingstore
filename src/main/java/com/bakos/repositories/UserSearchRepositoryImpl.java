package com.bakos.repositories;

import com.bakos.model.Game;
import com.bakos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserSearchRepositoryImpl implements UserSearchRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MongoOperations mongoOperations;


    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User findByName(String name) {
        User user = mongoTemplate.findOne(new Query(Criteria.where("fullName").is("Ala")), User.class);
        return user;
    }

    @Override
    public void save(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public void update(String name, Game game) {
        User user = mongoTemplate.findOne(Query.query(Criteria.where("fullName").is("Ala")), User.class);
        user.getGames().add(game);

        mongoTemplate.save(user);
    }


}
