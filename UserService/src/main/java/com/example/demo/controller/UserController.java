package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.PropertyDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * REST controller for managing users.
 * 
 * @author Shreyansh Singh
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Creates a new user.
     * 
     * @param user the user to create
     * @return a message indicating the result of the operation
     */
    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * Updates an existing user.
     * 
     * @param id the ID of the user to update
     * @param user the updated user information
     * @return the updated user
     */
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    /**
     * Deletes a user by ID.
     * 
     * @param id the ID of the user to delete
     * @return a message indicating the result of the operation
     */
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User Deleted successfully!";
    }

    /**
     * Retrieves a user by ID.
     * 
     * @param id the ID of the user to retrieve
     * @return the user, if found
     */
    @GetMapping("/get/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }
    
    @GetMapping("/getAllProperties")
	public List<PropertyDTO> getAllProperties(){
    	return userService.getAllProperties();
    }
}