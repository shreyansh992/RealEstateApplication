package com.example.demo.exceptions;

public class PaymentNotFound extends RuntimeException {
    public PaymentNotFound(String message) {
        super(message);
    }
}