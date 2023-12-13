package com.example.shems.service;

import com.example.shems.model.User;
import com.example.shems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Create a new user with a hashed password
public User createUser(User user) {
    String encodedPassword = passwordEncoder.encode(user.getPasswordHash());
    System.out.println("Password hashing process called");
    user.setPasswordHash(encodedPassword);
    
    // Save the user to the database
    User savedUser = userRepository.save(user);
    
    if (savedUser.getCustomer() != null) {
        // Set the User reference to the Customer
        savedUser.getCustomer().setUser(savedUser);
        // Save the User again to ensure the relationship is established
        userRepository.save(savedUser);
    }
    
    return savedUser;
}
public boolean isUserExists(String username) {
    return userRepository.findByUsername(username) != null;
}



    // Authenticate a user with a username and password
    public User authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPasswordHash())) {
            return user;
        }
        return null;
    }

    // Generate token (Placeholder - Implement your token generation logic)
    public String generateToken(User user) {
        // Implement JWT or any other token generation logic here
        // Example: return jwtTokenUtil.generateToken(user);
        return "token-placeholder";
    }

    // Find a user by ID
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    // Update a user (without changing the password)
    public User updateUser(Integer userId, User userDetails) {
        return userRepository.findById(userId).map(user -> {
            user.setUsername(userDetails.getUsername());
            // Update other fields as necessary, but exclude password
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + userId));
    }

    // Delete a user
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
