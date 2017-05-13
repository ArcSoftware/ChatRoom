package com.theironyard.charlotte.ChatRoom.controllers;

import com.theironyard.charlotte.ChatRoom.entities.Message;
import com.theironyard.charlotte.ChatRoom.entities.User;
import com.theironyard.charlotte.ChatRoom.services.MessageRepo;
import com.theironyard.charlotte.ChatRoom.services.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Jake on 5/13/17.
 */

@Controller
public class ChatRoomController {
    @Autowired
    MessageRepo messages;

    @Autowired
    UserRepo users;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        List<Message> messageList = (List<Message>) messages.findAll();
        model.addAttribute("name", session.getAttribute("userName"));
        return "public/index.html";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/add-messages", method = RequestMethod.POST)
    public String message(String message) {
        Message newMessage = new Message(message);
        messages.save(newMessage);
        return "redirect:/";
    }

}
