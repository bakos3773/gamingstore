package com.bakos.services;

import com.bakos.model.Friend;
import com.bakos.repositories.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    FriendRepository friendRepository;

    @Override
    public void save(Friend friend) {
        friendRepository.save(friend);
    }
}
