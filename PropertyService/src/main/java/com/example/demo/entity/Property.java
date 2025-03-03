package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representing a property.
 * 
 * @author Shreyansh Singh
 */
@Entity
@Table(name = "properties")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    /**
     * The unique identifier for the property.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the property.
     * Must not be blank.
     */
    @NotBlank(message = "Name is mandatory")
    private String name;

    /**
     * The location of the property.
     * Must not be blank.
     */
    @NotBlank(message = "Location is mandatory")
    private String location;

    /**
     * The price of the property.
     * Must be positive.
     */
    @Positive(message = "Price must be positive")
    private double price;

    /**
     * The number of bedrooms in the property.
     * Must be at least one.
     */
    @Min(value = 1, message = "There must be at least one bedroom")
    private int bedrooms;

    /**
     * The type of the property.
     * Must not be blank.
     */
    @NotBlank(message = "Type is mandatory")
    private String type;

    /**
     * The ID of the agent associated with the property.
     * Must be positive.
     */
    @Positive(message = "Agent ID must be positive")
    private int agentId;

    // Uncomment the following lines if you want to include bookings associated with the property
    // @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    // private List<Booking> bookings;
}