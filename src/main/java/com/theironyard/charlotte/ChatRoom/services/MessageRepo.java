package com.theironyard.charlotte.ChatRoom.services;

import com.theironyard.charlotte.ChatRoom.entities.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jake on 5/13/17.
 */
public interface MessageRepo extends CrudRepository<Message, Integer> {

}
