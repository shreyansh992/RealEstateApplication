package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Payment;
import com.example.demo.service.PaymentService;

import jakarta.validation.Valid;

/**
 * REST controller for managing payments.
 * 
 * @author Shreyansh Singh
 */
@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * Creates a new payment.
     *
     * @param payment the payment to create
     * @return the created payment
     */
    @PostMapping("/create")
    public Payment createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return createdPayment;
    }

    /**
     * Updates an existing payment.
     *
     * @param id the ID of the payment to update
     * @param payment the updated payment information
     * @return the updated payment
     */
    @PutMapping("/update/{id}")
    public Payment updatePayment(@PathVariable Long id, @Valid @RequestBody Payment payment) {
        Payment updatedPayment = paymentService.updatePayment(id, payment);
        return updatedPayment;
    }

    /**
     * Deletes a payment by ID.
     *
     * @param id the ID of the payment to delete
     * @return a message indicating the result of the operation
     */
    @DeleteMapping("/delete/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "Payment Deleted Successfully!";
    }

    /**
     * Retrieves a payment by ID.
     *
     * @param id the ID of the payment to retrieve
     * @return an Optional containing the payment if found, or empty if not found
     */
    @GetMapping("/get/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Long id) {
        Optional<Payment> payment = paymentService.findPaymentById(id);
        return payment;
    }

    /**
     * Retrieves payments by booking ID.
     *
     * @param bookingId the ID of the booking to retrieve payments for
     * @return a list of payments for the specified booking ID
     */
    @GetMapping("/booking/{bookingId}")
    public List<Payment> getPaymentsByBookingId(@PathVariable Long bookingId) {
        List<Payment> payments = paymentService.findPaymentsByBookingId(bookingId);
        return payments;
    }

    /**
     * Retrieves payments by status.
     *
     * @param status the status of the payments to retrieve
     * @return a list of payments with the specified status
     */
    @GetMapping("/status/{status}")
    public List<Payment> getPaymentsByStatus(@PathVariable String status) {
        List<Payment> payments = paymentService.findPaymentsByStatus(status);
        return payments;
    }

    /**
     * Retrieves payments within a date range.
     *
     * @param startDate the start date of the range
     * @param endDate the end date of the range
     * @return a list of payments within the specified date range
     */
    @GetMapping("/dateRange/{startDate}/{endDate}")
    public List<Payment> getPaymentsByDateRange(@PathVariable("startDate") LocalDate startDate, @PathVariable("endDate") LocalDate endDate) {
        List<Payment> payments = paymentService.findPaymentsByDateRange(startDate, endDate);
        return payments;
    }

    /**
     * Retrieves payments with an amount greater than the specified value.
     *
     * @param amount the minimum amount of the payments to retrieve
     * @return a list of payments with an amount greater than the specified value
     */
    @GetMapping("/amountGreaterThan/{amount}")
    public List<Payment> getPaymentsByAmountGreaterThan(@PathVariable double amount) {
        List<Payment> payments = paymentService.findPaymentsByAmountGreaterThan(amount);
        return payments;
    }

    /**
     * Retrieves payments with an amount less than the specified value.
     *
     * @param amount the maximum amount of the payments to retrieve
     * @return a list of payments with an amount less than the specified value
     */
    @GetMapping("/amountLessThan/{amount}")
    public List<Payment> getPaymentsByAmountLessThan(@PathVariable double amount) {
        List<Payment> payments = paymentService.findPaymentsByAmountLessThan(amount);
        return payments;
    }

    /**
     * Retrieves payments by booking ID and status.
     *
     * @param bookingId the ID of the booking to retrieve payments for
     * @param status the status of the payments to retrieve
     * @return a list of payments with the specified booking ID and status
     */
    @GetMapping("/byBookingIdAndStatus/{bookingId}/{status}")
    public List<Payment> getPaymentsByBookingIdAndStatus(@PathVariable Long bookingId, @PathVariable String status) {
        List<Payment> payments = paymentService.findPaymentsByBookingIdAndStatus(bookingId, status);
        return payments;
    }
}