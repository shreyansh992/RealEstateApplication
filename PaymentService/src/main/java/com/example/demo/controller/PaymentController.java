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

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public Payment createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return createdPayment;
    }

    @PutMapping("/update/{id}")
    public Payment updatePayment(@PathVariable Long id, @Valid @RequestBody Payment payment) {
        Payment updatedPayment = paymentService.updatePayment(id, payment);
        return updatedPayment;
    }

    @DeleteMapping("/delete/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "Payment Deleted Successfully!";
    }

    @GetMapping("/get/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Long id) {
        Optional<Payment> payment = paymentService.findPaymentById(id);
        return payment;
    }

    @GetMapping("/booking/{bookingId}")
    public List<Payment> getPaymentsByBookingId(@PathVariable Long bookingId) {
        List<Payment> payments = paymentService.findPaymentsByBookingId(bookingId);
        return payments;
    }

    @GetMapping("/status/{status}")
    public List<Payment> getPaymentsByStatus(@PathVariable String status) {
        List<Payment> payments = paymentService.findPaymentsByStatus(status);
        return payments;
    }

    @GetMapping("/dateRange")
    public List<Payment> getPaymentsByDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        List<Payment> payments = paymentService.findPaymentsByDateRange(startDate, endDate);
        return payments;
    }

    @GetMapping("/amountGreaterThan")
    public List<Payment> getPaymentsByAmountGreaterThan(@RequestParam double amount) {
        List<Payment> payments = paymentService.findPaymentsByAmountGreaterThan(amount);
        return payments;
    }

    @GetMapping("/amountLessThan")
    public List<Payment> getPaymentsByAmountLessThan(@RequestParam double amount) {
        List<Payment> payments = paymentService.findPaymentsByAmountLessThan(amount);
        return payments;
    }

    @GetMapping("/byBookingIdAndStatus/{bookingId}/{status}")
    public List<Payment> getPaymentsByBookingIdAndStatus(@PathVariable Long bookingId, @PathVariable String status) {
        List<Payment> payments = paymentService.findPaymentsByBookingIdAndStatus(bookingId, status);
        return payments;
    }
}