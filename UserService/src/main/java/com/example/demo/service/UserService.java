package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.PropertyDTO;
import com.example.demo.entity.User;

/**
 * Service interface for managing users.
 * 
 * @author Shreyansh Singh
 */
public interface UserService {

    /**
     * Creates a new user.
     * 
     * @param user the user to create
     * @return a message indicating the result of the operation
     */
    String createUser(User user);

    /**
     * Updates an existing user.
     * 
     * @param userId the ID of the user to update
     * @param user the updated user information
     * @return the updated user
     */
    User updateUser(Long userId, User user);

    /**
     * Deletes a user by ID.
     * 
     * @param userId the ID of the user to delete
     */
    void deleteUser(Long userId);

    /**
     * Finds a user by ID.
     * 
     * @param userId the ID of the user to find
     * @return an Optional containing the found user, if any
     */
    Optional<User> findUserById(Long userId);

    /**
     * Finds a user by username.
     * 
     * @param username the username to search for
     * @return an Optional containing the found user, if any
     */
    Optional<User> findUserByUsername(String username);

    /**
     * Finds a user by email.
     * 
     * @param email the email to search for
     * @return an Optional containing the found user, if any
     */
    Optional<User> findUserByEmail(String email);

    /**
     * Finds all users.
     * 
     * @return a list of all users
     */
    List<User> findAllUsers();

    /**
     * Finds users by role.
     * 
     * @param role the role to search for
     * @return a list of users with the specified role
     */
    List<User> findUsersByRole(String role);

    /**
     * Finds users by status.
     * 
     * @param status the status to search for
     * @return a list of users with the specified status
     */
    List<User> findUsersByStatus(String status);
    List<PropertyDTO> getAllProperties();
}