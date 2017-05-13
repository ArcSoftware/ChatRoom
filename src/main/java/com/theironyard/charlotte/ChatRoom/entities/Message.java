package com.theironyard.charlotte.ChatRoom.entities;

import javax.persistence.*;

/**
 * Created by Jake on 5/13/17.
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
        int id;

    @Column(nullable = false)
        String message;

    @ManyToOne
        User user;


    public Message(String message) {
        this.message = message;
    }

    public Message() {
    }
}
