package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.BookingDTO;
import com.example.demo.entity.Property;
import com.example.demo.service.PropertyService;

/**
 * REST controller for managing properties.
 * 
 * @author Shreyansh Singh
 */
@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    /**
     * Creates a new property.
     * 
     * @param property the property to create
     * @return a message indicating the result of the operation
     */
    @PostMapping("/create")
    public String createProperty(@RequestBody Property property) {
        return propertyService.createProperty(property);
        
    }
    
    /**
     * 
	 * @return a list of all properties
	 */
    @GetMapping("/getAll")
    public List<Property> findAll() {
        List<Property> properties = propertyService.findAll();
        return properties;
    }

    /**
     * Retrieves a property by ID.
     * 
     * @param id the ID of the property to retrieve
     * @return the property, if found
     */
    @GetMapping("/get/{id}")
    public Optional<Property> getPropertyById(@PathVariable Long id) {
        Optional<Property> property = propertyService.findPropertyById(id);
        return property;
    }

    /**
     * Updates an existing property.
     * 
     * @param id the ID of the property to update
     * @param property the updated property information
     * @return the updated property
     */
    @PutMapping("/update/{id}")
    public Property updateProperty(@PathVariable Long id, @RequestBody Property property) {
        Property updatedProperty = propertyService.updateProperty(id, property);
        return updatedProperty;
    }

    /**
     * Deletes a property by ID.
     * 
     * @param id the ID of the property to delete
     * @return a message indicating the result of the operation
     */
    @DeleteMapping("/delete/{id}")
    public String deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return "Property Deleted Successfully!";
    }
    
    /**
     * Creates a new booking for a property.
     * 
     * @param bookingDTO the booking data transfer object containing booking details
     * @return a message indicating the result of the operation
     */
    @PostMapping("/createBooking")
    public String createBooking(@RequestBody BookingDTO bookingDTO) {
    	return propertyService.createBooking(bookingDTO);
    }
}