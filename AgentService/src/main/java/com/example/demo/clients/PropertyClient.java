package com.example.demo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.DTO.PropertyDTO;

/**
 * Feign client for interacting with the Property service.
 * 
 * @author Shreyansh Singh
 */
@FeignClient(name = "properties", url = "http://localhost:9002/properties")
public interface PropertyClient {

    /**
     * Creates a new property.
     * 
     * @param propertyDTO the property data transfer object containing property details
     * @return a message indicating the result of the operation
     */
    @PostMapping("/create")
    public String createProperty(@RequestBody PropertyDTO propertyDTO);
}