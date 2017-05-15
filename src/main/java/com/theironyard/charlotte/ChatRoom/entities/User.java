package com.theironyard.charlotte.ChatRoom.entities;

import javax.persistence.*;

/**
 * Created by Jake on 5/13/17.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;


    public User() {
    }

    public User(String username) {
        this.name = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}