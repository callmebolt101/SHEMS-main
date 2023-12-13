package com.example.shems.model;

public class LoginResponse {
    private String token;
    private User user;
    private Customer customer; // Include customer field

    // No-args constructor
    public LoginResponse() {
    }

    // Constructor with all fields
    public LoginResponse(String token, User user, Customer customer) {
        this.token = token;
        this.user = user;
        this.customer = customer;
    }

    // Getters and setters for all fields
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
