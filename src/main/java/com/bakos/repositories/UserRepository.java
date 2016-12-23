package com.bakos.repositories;


import com.bakos.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface UserRepository extends MongoRepository<User, BigInteger> {


}
