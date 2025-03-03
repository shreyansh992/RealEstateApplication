package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

/**
 * Repository interface for managing User entities.
 * 
 * @author Shreyansh Singh
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by username.
     * 
     * @param username the username to search for
     * @return an Optional containing the found user, if any
     */
    Optional<User> findByUsername(String username);

    /**
     * Finds a user by email.
     * 
     * @param email the email to search for
     * @return an Optional containing the found user, if any
     */
    Optional<User> findByEmail(String email);

    /**
     * Finds users by role.
     * 
     * @param role the role to search for
     * @return a list of users with the specified role
     */
    List<User> findByRole(String role);

    /**
     * Finds users by status.
     * 
     * @param status the status to search for
     * @return a list of users with the specified status
     */
    List<User> findByStatus(String status);

    /**
     * Finds users created between the specified dates.
     * 
     * @param startDate the start date of the range
     * @param endDate the end date of the range
     * @return a list of users created between the specified dates
     */
    List<User> findByCreatedDateBetween(LocalDate startDate, LocalDate endDate);

    /**
     * Finds users who last logged in before the specified date.
     * 
     * @param date the date to compare against
     * @return a list of users who last logged in before the specified date
     */
    List<User> findByLastLoginDateBefore(LocalDate date);

    /**
     * Finds users by email domain using a custom query.
     * 
     * @param domain the email domain to search for
     * @return a list of users with the specified email domain
     */
    @Query("SELECT u FROM User u WHERE u.email LIKE %:domain%")
    List<User> findByEmailDomain(@Param("domain") String domain);
}