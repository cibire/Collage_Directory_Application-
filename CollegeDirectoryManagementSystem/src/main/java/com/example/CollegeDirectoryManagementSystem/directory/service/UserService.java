//package com.example.CollegeDirectoryManagementSystem.directory.service;
//
//import com.example.CollegeDirectoryManagementSystem.directory.model.User;
//import com.example.CollegeDirectoryManagementSystem.directory.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public User getUserById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    public void saveUser(User user) {
//        userRepository.save(user);
//    }
//
//    public void updateUser(Long id, User updatedUser) {
//        User existingUser = getUserById(id);
//        if (existingUser != null) {
//            existingUser.setName(updatedUser.getName());
//            existingUser.setEmail(updatedUser.getEmail());
//            existingUser.setRole(updatedUser.getRole());
//            userRepository.save(existingUser);
//        }
//    }
//
//    public void deleteUserById(Long id) {
//        userRepository.deleteById(id);
//    }
//}
package com.example.CollegeDirectoryManagementSystem.directory.service;

import com.example.CollegeDirectoryManagementSystem.directory.model.User;
import com.example.CollegeDirectoryManagementSystem.directory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setRole(updatedUser.getRole());
            userRepository.save(existingUser);
        }
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
