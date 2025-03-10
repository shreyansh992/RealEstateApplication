package com.example.demo.exceptions;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class UserGlobalException { 
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", new Date());
		// Get all errors
		ex.getBindingResult().getAllErrors().forEach(error -> {
				body.put(((FieldError)error).getField(),error.getDefaultMessage());
			});
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<ExceptionResponse> handleConstraintViolationException(ConstraintViolationException ex) {
	    String errors = ex.getConstraintViolations().stream()
	            .map(ConstraintViolation::getMessage)
	            .collect(Collectors.joining(", "));

	    ExceptionResponse exceptionResponse = new ExceptionResponse();
	    exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.value());
	    exceptionResponse.setTime(LocalDateTime.now());
	    exceptionResponse.setMessage(errors);

	    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = UserNotFound.class)
	public ResponseEntity<ExceptionResponse> handleAdminRegistrationException(UserNotFound exception,
			WebRequest webRequest) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);

	}
	

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionResponse> handleAccountIdException(Exception exception, WebRequest webRequest) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());

		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);

	}
}