package com.example.shems.controller;

import com.example.shems.model.Customer;
import com.example.shems.model.LoginRequest;
import com.example.shems.model.LoginResponse;
import com.example.shems.model.User;
import com.example.shems.service.CustomerService;
import com.example.shems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    // Endpoint for user registration
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        System.out.println("Received registration request for user: " + user);
        if (userService.isUserExists(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already registered");
        }

        User savedUser = userService.createUser(user);
        if (savedUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }
    }


    // Endpoint for user login
    @PostMapping("/login_user")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        User user = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            Optional<Customer> customer = customerService.findById(user.getUserId());
            if (customer.isPresent()) {
                // Assuming you have a method to generate a token
                String token = userService.generateToken(user);
                LoginResponse loginResponse = new LoginResponse(token, user, customer.get());
                return ResponseEntity.ok(loginResponse);
            } else {
                return ResponseEntity.status(404).body("Customer details not found for the user");
            }
        } else {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

    // Other endpoints as needed
}
