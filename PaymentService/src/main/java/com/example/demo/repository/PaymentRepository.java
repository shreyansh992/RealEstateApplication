package com.example.demo.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByBookingId(Long bookingId);
    List<Payment> findByStatus(String status);
    List<Payment> findByPaymentDateBetween(LocalDate startDate, LocalDate endDate);

    // Custom query to find payments by amount greater than a specific value
    @Query("SELECT p FROM Payment p WHERE p.amount > :amount")
    List<Payment> findByAmountGreaterThan(@Param("amount") double amount);

    // Custom query to find payments by amount less than a specific value
    @Query("SELECT p FROM Payment p WHERE p.amount < :amount")
    List<Payment> findByAmountLessThan(@Param("amount") double amount);

    // Custom query to find payments by booking ID and status
    @Query("SELECT p FROM Payment p WHERE p.bookingId = :bookingId AND p.status = :status")
    List<Payment> findByBookingIdAndStatus(@Param("bookingId") Long bookingId, @Param("status") String status);
}

