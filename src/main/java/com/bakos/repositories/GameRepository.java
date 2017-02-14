package com.bakos.repositories;

import com.bakos.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface GameRepository extends MongoRepository<Game, String>{


}
