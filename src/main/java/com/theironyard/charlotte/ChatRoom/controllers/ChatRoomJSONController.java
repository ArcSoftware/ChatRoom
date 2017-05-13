package com.theironyard.charlotte.ChatRoom.controllers;

import com.theironyard.charlotte.ChatRoom.entities.Message;
import com.theironyard.charlotte.ChatRoom.services.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by Jake on 5/13/17.
 */

@RestController
public class ChatRoomJSONController {
    @Autowired
    MessageRepo messages;

    @RequestMapping(path = "/get-messages", method = RequestMethod.GET)
    public ArrayList<Message> jsonReturn(Message messageText) {

        return (ArrayList<Message>) messages.findAll();
    }


    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public void jsonAdd(@RequestBody String message) {
        Message newMessage = new Message(message);
        messages.save(newMessage);
    }



}