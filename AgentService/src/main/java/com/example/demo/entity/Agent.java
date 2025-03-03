package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
 * Entity class representing a agent.
 * 
 * @author Shreyansh Singh
 */
@Entity
@Table(name = "agents")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agent {

    /**
     * The unique identifier for the agent.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The first name of the agent.
     * Must not be blank.
     */
    @NotBlank(message = "First name is mandatory")
    private String firstName;

    /**
     * The last name of the agent.
     * Must not be blank.
     */
    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    /**
     * The email address of the agent.
     * Must be a valid email format and not blank.
     */
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    /**
     * The phone number of the agent.
     * Must not be blank.
     */
    @NotBlank(message = "Phone is mandatory")
    private String phone;

    /**
     * The license number of the agent.
     * Must not be blank.
     */
    @NotBlank(message = "License number is mandatory")
    private String licenseNumber;

    /**
     * The date when the agent was created.
     * Formatted as yyyy-MM-dd.
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    // Uncomment the following lines if you want to include properties associated with the agent
    // @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Property> properties;
}