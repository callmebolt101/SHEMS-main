package com.example.shems.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the Spring Boot Application!";
    }

    @Autowired
    private DataSource dataSource; // Autowire the DataSource

    @GetMapping("/testdb")
    public ResponseEntity<String> testDatabaseConnection() {
        try {
            Connection connection = dataSource.getConnection(); // Attempt to get a database connection
            connection.close(); // Close the connection if successful
            return ResponseEntity.ok("Database connection test successful.");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Database connection test failed: " + e.getMessage());
        }
    }
}
