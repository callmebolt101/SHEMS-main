package com.example.shems.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId") // Match this with the exact column name in your database
    private Integer userId;

    // @Column(nullable = false, unique = true)
    @Column(name = "username")
    private String username;

    // @Column(nullable = false)
    @Column(name = "password_hash")
    private String passwordHash;
    // Standard getters and setters...

    // Getters and setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}

