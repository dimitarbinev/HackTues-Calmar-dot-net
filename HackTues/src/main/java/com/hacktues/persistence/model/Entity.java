package com.hacktues.persistence.model;

import jakarta.persistence.*;

@Table(name = "users")
@jakarta.persistence.Entity
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public String getUsername() {
        return username;
    }

    @Column(nullable = false, unique = true)
    private String username;

    public String getPassword() {
        return password;
    }

    @Column(nullable = false)
    private String password;
}
