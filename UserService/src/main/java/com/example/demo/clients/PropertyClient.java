package com.example.demo.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.DTO.PropertyDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient("PROPERTYSERVICE")
public interface PropertyClient {
	@GetMapping("/properties/getAll")
	@CircuitBreaker(name = "findAll", fallbackMethod = "fallbackFindAll")
//    @Retry(name = "propertyClient")
	public List<PropertyDTO> findAll();
	
	default List<PropertyDTO> fallbackFindAll(Throwable t) {
        System.out.println("Fallback method called");
        return List.of(); // Return an empty list or some default response
    }
}