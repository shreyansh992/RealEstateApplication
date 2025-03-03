package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a user.
 * 
 * @author Shreyansh Singh
 */
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * The unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The username of the user.
     * Must not be blank.
     */
    @NotBlank(message = "Username is mandatory")
    private String username;

    /**
     * The password of the user.
     * Must not be blank.
     */
    @NotBlank(message = "Password is mandatory")
    private String password;

    /**
     * The email of the user.
     * Must be a valid email format and not blank.
     */
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    /**
     * The role of the user.
     * Must not be blank.
     */
    @NotBlank(message = "Role is mandatory")
    private String role;

    /**
     * The status of the user.
     * Must not be blank.
     */
    @NotBlank(message = "Status is mandatory")
    private String status;

    /**
     * The date when the user was created.
     */
    private LocalDate createdDate;

    /**
     * The date when the user last logged in.
     */
    private LocalDate lastLoginDate;

    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    // private List<Booking> bookings;
}