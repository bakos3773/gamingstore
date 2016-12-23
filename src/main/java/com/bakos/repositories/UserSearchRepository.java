package com.bakos.repositories;


import com.bakos.model.User;

import java.util.List;

public interface UserSearchRepository {

    public List<User> findAll();
}
