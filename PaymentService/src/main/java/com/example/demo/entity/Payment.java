package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
 * Entity representing a payment.
 * 
 * @author Shreyansh Singh
 */
@Entity
@Table(name = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    /**
     * The unique identifier for the payment.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The amount of the payment.
     * Must be positive.
     */
    @Positive(message = "Amount must be positive")
    private double amount;

    /**
     * The status of the payment.
     * Must not be blank.
     */
    @NotBlank(message = "Status is mandatory")
    private String status;

    /**
     * The date of the payment.
     * Formatted as yyyy-MM-dd.
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;

    /**
     * The ID of the booking associated with the payment.
     * Must be positive.
     */
    @Positive(message = "Booking ID must be positive")
    private int bookingId;
}