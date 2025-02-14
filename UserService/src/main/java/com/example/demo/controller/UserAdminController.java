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

@RestController
@RequestMapping("/usersAdmin")
public class UserAdminController {
	
	@Autowired
    private UserService userService;
	
	@GetMapping("/byUsername/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
    	return userService.findUserByUsername(username);
    }

    @GetMapping("/byEmail/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
    	return userService.findUserByEmail(email);
    }
    
	@GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/byRole/{role}")
    public List<User> getUsersByRole(@PathVariable String role) {
        return userService.findUsersByRole(role);
    }

    @GetMapping("/byStatus/{status}")
    public List<User> getUsersByStatus(@PathVariable String status) {
        return userService.findUsersByStatus(status);
    }
	
}
