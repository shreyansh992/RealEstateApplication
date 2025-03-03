package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Payment;
/**
 * Service interface for managing payments.
 * 
 * @author Shreyansh Singh
 */
public interface PaymentService {
	/**
     * Creates a new payment.
     * 
     * @param payment the payment to create
     * @return the created payment
     */
    Payment createPayment(Payment payment);
    /**
     * Updates an existing payment.
     * 
     * @param paymentId the ID of the payment to update
     * @param payment the updated payment information
     * @return the updated payment
     */
    Payment updatePayment(Long paymentId, Payment payment);
    /**
     * Deletes a payment by ID.
     * 
     * @param paymentId the ID of the payment to delete
     */
    void deletePayment(Long paymentId);
    /**
     * Finds a payment by ID.
     * 
     * @param paymentId the ID of the payment to find
     * @return an Optional containing the found payment, if any
     */
    Optional<Payment> findPaymentById(Long paymentId);
    /**
     * Finds payments by booking ID.
     * 
     * @param bookingId the booking ID to search for
     * @return a list of payments with the specified booking ID
     */
    List<Payment> findPaymentsByBookingId(Long bookingId);
    /**
     * Finds payments by booking ID.
     * 
     * @param bookingId the booking ID to search for
     * @return a list of payments with the specified booking ID
     */
    List<Payment> findPaymentsByStatus(String status);
    /**
     * Finds payments within a specified date range.
     * 
     * @param startDate the start date of the range
     * @param endDate the end date of the range
     * @return a list of payments within the specified date range
     */
    List<Payment> findPaymentsByDateRange(LocalDate startDate, LocalDate endDate);
    /**
     * Finds payments with an amount greater than the specified amount.
     * 
     * @param amount the amount to compare against
     * @return a list of payments with an amount greater than the specified amount
     */
    List<Payment> findPaymentsByAmountGreaterThan(double amount);
    /**
     * Finds payments with an amount less than the specified amount.
     * 
     * @param amount the amount to compare against
     * @return a list of payments with an amount less than the specified amount
     */
    List<Payment> findPaymentsByAmountLessThan(double amount);
    /**
     * Finds payments by booking ID and status.
     * 
     * @param bookingId the booking ID to search for
     * @param status the status to search for
     * @return a list of payments with the specified booking ID and status
     */
    List<Payment> findPaymentsByBookingIdAndStatus(Long bookingId, String status);
}
