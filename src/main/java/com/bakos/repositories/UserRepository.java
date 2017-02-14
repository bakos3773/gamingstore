package com.bakos.repositories;


import com.bakos.model.Game;
import com.bakos.model.User;
import com.mongodb.DBObject;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByConfirmationId(String confirmationId);

}