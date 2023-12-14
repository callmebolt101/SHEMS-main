package com.example.shems.service;

import com.example.shems.model.User;
import com.example.shems.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    // Authenticate a user with a username and password
    public User authenticateUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user != null && password.equals(user.get().getPasswordHash())) {
            return user.get();
        }
        return null;
    }
}
