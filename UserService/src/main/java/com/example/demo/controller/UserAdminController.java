package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * REST controller for managing users with admin privileges.
 * 
 * @author Shreyansh Singh
 */
@RestController
@RequestMapping("/usersAdmin")
public class UserAdminController {

    @Autowired
    private UserService userService;

    /**
     * Retrieves a user by username.
     * 
     * @param username the username of the user to retrieve
     * @return the user, if found
     */
    @GetMapping("/byUsername/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    /**
     * Retrieves a user by email.
     * 
     * @param email the email of the user to retrieve
     * @return the user, if found
     */
    @GetMapping("/byEmail/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    /**
     * Retrieves all users.
     * 
     * @return a list of all users
     */
    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    /**
     * Retrieves users by role.
     * 
     * @param role the role of the users to retrieve
     * @return a list of users with the specified role
     */
    @GetMapping("/byRole/{role}")
    public List<User> getUsersByRole(@PathVariable String role) {
        return userService.findUsersByRole(role);
    }

    /**
     * Retrieves users by status.
     * 
     * @param status the status of the users to retrieve
     * @return a list of users with the specified status
     */
    @GetMapping("/byStatus/{status}")
    public List<User> getUsersByStatus(@PathVariable String status) {
        return userService.findUsersByStatus(status);
    }
}