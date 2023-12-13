package com.example.shems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.shems.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
