package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representing a booking.
 * 
 * @author Shreyansh Singh
 */
@Entity
@Table(name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    /**
     * The unique identifier for the booking.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The ID of the user making the booking.
     * Must be positive.
     */
    @Positive(message = "User ID must be positive")
    private int userId;

    /**
     * The ID of the property being booked.
     * Must be positive.
     */
    @Positive(message = "Property ID must be positive")
    private int propertyId;

    /**
     * The date of the booking.
     */
    private LocalDate bookingDate;

    /**
     * The status of the booking.
     * Must not be blank.
     */
    @NotBlank(message = "Status is mandatory")
    private String status;
}