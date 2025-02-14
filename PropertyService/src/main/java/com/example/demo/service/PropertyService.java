package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.BookingDTO;
import com.example.demo.entity.Property;

public interface PropertyService {

    String createProperty(Property property);
    Property updateProperty(Long propertyId, Property property);
    void deleteProperty(Long propertyId);
    String createBooking(BookingDTO bookingDTO);
    Optional<Property> findPropertyById(Long propertyId);
    List<Property> findPropertiesByLocation(String location);
    List<Property> findPropertiesByPriceRange(double minPrice, double maxPrice);
    List<Property> findPropertiesByType(String type);
    List<Property> findPropertiesByBedrooms(int bedrooms);
    List<Property> findPropertiesByNameContainsIgnoreCase(String name);
    List<Property> findPropertiesByPriceGreaterThan(double price);
    List<Property> findPropertiesByPriceLessThan(double price);
    List<Property> findAll();
}
