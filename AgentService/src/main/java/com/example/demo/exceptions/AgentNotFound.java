package com.example.demo.exceptions;

public class AgentNotFound extends RuntimeException {
    public AgentNotFound(String message) {
        super(message);
    }
}
