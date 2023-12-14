package com.example.shems.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shems.model.Customer;
import com.example.shems.model.LoginRequest;
import com.example.shems.model.User;
import com.example.shems.service.CustomerService;
import com.example.shems.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;


    // Endpoint for user login
    @PostMapping("/login_user")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        User user = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            System.out.println(user.getUserId());
            Optional<Customer> customer = customerService.findById(user.getUserId());
            if (customer.isPresent()) {
                return ResponseEntity.status(200).body("Login Successful!");
            } else {
                return ResponseEntity.status(404).body("Customer details not found for the user");
            }
        } else {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

}

