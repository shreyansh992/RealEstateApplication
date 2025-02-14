package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Payment;

public interface PaymentService {

    Payment createPayment(Payment payment);
    Payment updatePayment(Long paymentId, Payment payment);
    void deletePayment(Long paymentId);
    Optional<Payment> findPaymentById(Long paymentId);
    List<Payment> findPaymentsByBookingId(Long bookingId);
    List<Payment> findPaymentsByStatus(String status);
    List<Payment> findPaymentsByDateRange(LocalDate startDate, LocalDate endDate);
    List<Payment> findPaymentsByAmountGreaterThan(double amount);
    List<Payment> findPaymentsByAmountLessThan(double amount);
    List<Payment> findPaymentsByBookingIdAndStatus(Long bookingId, String status);
}
