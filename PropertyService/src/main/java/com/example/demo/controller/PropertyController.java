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

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/create")
    public String createProperty(@RequestBody Property property) {
        return propertyService.createProperty(property);
        
    }
    
    @GetMapping("/getAll")
    public List<Property> findAll() {
        List<Property> properties = propertyService.findAll();
        return properties;
    }

    @GetMapping("/get/{id}")
    public Optional<Property> getPropertyById(@PathVariable Long id) {
        Optional<Property> property = propertyService.findPropertyById(id);
        return property;
    }

    @PutMapping("/update/{id}")
    public Property updateProperty(@PathVariable Long id, @RequestBody Property property) {
        Property updatedProperty = propertyService.updateProperty(id, property);
        return updatedProperty;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return "Property Deleted Successfully!";
    }
    
    @PostMapping("/createBooking")
    public String createBooking(@RequestBody BookingDTO bookingDTO) {
    	return propertyService.createBooking(bookingDTO);
    }
}