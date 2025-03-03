package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Payment;
import com.example.demo.exceptions.PaymentNotFound;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Long paymentId, Payment payment) {
        Optional<Payment> existingPayment = paymentRepository.findById(paymentId);
        if (existingPayment.isPresent()) {
            Payment updatedPayment = existingPayment.get();
            updatedPayment.setBookingId(payment.getBookingId());
            updatedPayment.setAmount(payment.getAmount());
            updatedPayment.setStatus(payment.getStatus());
            updatedPayment.setPaymentDate(payment.getPaymentDate());
            return paymentRepository.save(updatedPayment);
        } else {
            throw new PaymentNotFound("Payment not found with id " + paymentId);
        }
    }

    @Override
    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public Optional<Payment> findPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public List<Payment> findPaymentsByBookingId(Long bookingId) {
        return paymentRepository.findByBookingId(bookingId);
    }

    @Override
    public List<Payment> findPaymentsByStatus(String status) {
        return paymentRepository.findByStatus(status);
    }

    @Override
    public List<Payment> findPaymentsByDateRange(LocalDate startDate, LocalDate endDate) {
        return paymentRepository.findByPaymentDateBetween(startDate, endDate);
    }

    @Override
    public List<Payment> findPaymentsByAmountGreaterThan(double amount) {
        return paymentRepository.findByAmountGreaterThan(amount);
    }

    @Override
    public List<Payment> findPaymentsByAmountLessThan(double amount) {
        return paymentRepository.findByAmountLessThan(amount);
    }

    @Override
    public List<Payment> findPaymentsByBookingIdAndStatus(Long bookingId, String status) {
        return paymentRepository.findByBookingIdAndStatus(bookingId, status);
    }
}