package com.example.demo.exceptions;

public class PropertyNotFound extends RuntimeException {
	public PropertyNotFound(String message) {
        super(message);
    }
}
