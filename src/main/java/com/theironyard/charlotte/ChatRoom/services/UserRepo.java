package com.theironyard.charlotte.ChatRoom.services;

import com.theironyard.charlotte.ChatRoom.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jake on 5/13/17.
 */
public interface UserRepo extends CrudRepository<User, Integer> {
    User findFirstByName(String userName);
}
