package com.example.demo.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Payment;
/**
 * Repository interface for managing payments.
 * 
 * @author Shreyansh Singh
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	/**
     * Finds payments by booking ID.
     * 
     * @param bookingId the booking ID to search for
     * @return a list of payments with the specified booking ID
     */
    List<Payment> findByBookingId(Long bookingId);
    /**
     * Finds payments by status.
     * 
     * @param status the status to search for
     * @return a list of payments with the specified status
     */
    List<Payment> findByStatus(String status);
    /**
     * Finds payments within a specified date range.
     * 
     * @param startDate the start date of the range
     * @param endDate the end date of the range
     * @return a list of payments within the specified date range
     */
    List<Payment> findByPaymentDateBetween(LocalDate startDate, LocalDate endDate);
    /**
     * Finds payments by amount greater than a specific value.
     * 
     * @param amount the minimum amount
     * @return a list of payments with an amount greater than the specified value
     */
    @Query("SELECT p FROM Payment p WHERE p.amount > :amount")
    List<Payment> findByAmountGreaterThan(@Param("amount") double amount);
    /**
     * Finds payments by amount less than a specific value.
     * 
     * @param amount the maximum amount
     * @return a list of payments with an amount less than the specified value
     */
    @Query("SELECT p FROM Payment p WHERE p.amount < :amount")
    List<Payment> findByAmountLessThan(@Param("amount") double amount);
    /**
     * Finds payments by booking ID and status.
     * 
     * @param bookingId the booking ID to search for
     * @param status the status to search for
     * @return a list of payments with the specified booking ID and status
     */
    @Query("SELECT p FROM Payment p WHERE p.bookingId = :bookingId AND p.status = :status")
    List<Payment> findByBookingIdAndStatus(@Param("bookingId") Long bookingId, @Param("status") String status);
}

