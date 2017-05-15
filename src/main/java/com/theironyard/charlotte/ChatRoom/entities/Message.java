package com.theironyard.charlotte.ChatRoom.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column
    LocalDateTime added;

    @ManyToOne
    User user;


    public Message(String message) {
        this.message = message;
    }

    public Message() {
    }

    public LocalDateTime getAdded() {
        return added;
    }

    public void setAdded(LocalDateTime added) {
        this.added = added;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
