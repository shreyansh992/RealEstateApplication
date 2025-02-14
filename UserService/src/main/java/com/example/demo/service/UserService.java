package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;

public interface UserService {

    String createUser(User user);
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
    Optional<User> findUserById(Long userId);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
    List<User> findAllUsers();
    List<User> findUsersByRole(String role);
    List<User> findUsersByStatus(String status);
}
