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

    @Column(nullable = false, unique = true)
        private String name;


    public User() {
    }


}