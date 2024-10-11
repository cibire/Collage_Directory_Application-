package com.example.CollegeDirectoryManagementSystem.directory.repository;

import com.example.CollegeDirectoryManagementSystem.directory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Change 'class' to 'interface' and extend JpaRepository properly
public interface UserRepository extends JpaRepository<User, Long> {
    // Define the method as per JpaRepository standards
    Optional<User> findByUsername(String username);
}
