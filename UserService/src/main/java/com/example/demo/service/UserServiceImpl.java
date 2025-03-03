package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.PropertyDTO;
import com.example.demo.clients.PropertyClient;
import com.example.demo.entity.User;
import com.example.demo.exceptions.UserNotFound;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    PropertyClient client;

    @Override
    public String createUser(User user) {
//        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
//            throw new ValidationException("Email is already in use: " + user.getEmail());
//        }
        userRepository.save(user);
        return "User Created Successfully!";
    }

    @Override
    public User updateUser(Long userId, User user) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setCreatedDate(user.getCreatedDate());
            updatedUser.setLastLoginDate(user.getLastLoginDate());
            updatedUser.setRole(user.getRole());
            updatedUser.setStatus(user.getStatus());
            // Update other fields as necessary
            return userRepository.save(updatedUser);
        } else {
            throw new UserNotFound("User not found with id " + userId);
        }
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    @Override
    public List<User> findUsersByStatus(String status) {
        return userRepository.findByStatus(status);
    }
    
    @Override
    public List<PropertyDTO> getAllProperties(){
    	return client.findAll();
    }
}
