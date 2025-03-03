package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.BookingDTO;
import com.example.demo.entity.Property;

/**
 * Service interface for managing properties.
 * 
 * @author Shreyansh Singh
 */
public interface PropertyService {

    /**
     * Creates a new property.
     *
     * @param property the property to create
     * @return a message indicating the result of the operation
     */
    String createProperty(Property property);

    /**
     * Updates an existing property.
     *
     * @param propertyId the ID of the property to update
     * @param property the updated property information
     * @return the updated property
     */
    Property updateProperty(Long propertyId, Property property);

    /**
     * Deletes a property by ID.
     *
     * @param propertyId the ID of the property to delete
     */
    void deleteProperty(Long propertyId);

    /**
     * Creates a new booking for a property.
     *
     * @param bookingDTO the booking details
     * @return a message indicating the result of the operation
     */
    String createBooking(BookingDTO bookingDTO);

    /**
     * Retrieves a property by ID.
     *
     * @param propertyId the ID of the property to retrieve
     * @return an Optional containing the property if found, or empty if not found
     */
    Optional<Property> findPropertyById(Long propertyId);

    /**
     * Finds properties by location.
     *
     * @param location the location to search for properties
     * @return a list of properties in the specified location
     */
    List<Property> findPropertiesByLocation(String location);

    /**
     * Finds properties within a specified price range.
     *
     * @param minPrice the minimum price
     * @param maxPrice the maximum price
     * @return a list of properties within the specified price range
     */
    List<Property> findPropertiesByPriceRange(double minPrice, double maxPrice);

    /**
     * Finds properties by type.
     *
     * @param type the type of properties to search for
     * @return a list of properties of the specified type
     */
    List<Property> findPropertiesByType(String type);

    /**
     * Finds properties by the number of bedrooms.
     *
     * @param bedrooms the number of bedrooms
     * @return a list of properties with the specified number of bedrooms
     */
    List<Property> findPropertiesByBedrooms(int bedrooms);

    /**
     * Finds properties by name, case insensitive.
     *
     * @param name the name to search for
     * @return a list of properties with names containing the specified string, ignoring case
     */
    List<Property> findPropertiesByNameContainsIgnoreCase(String name);

    /**
     * Finds properties with a price above a specific value.
     *
     * @param price the minimum price
     * @return a list of properties with a price above the specified value
     */
    List<Property> findPropertiesByPriceGreaterThan(double price);

    /**
     * Finds properties with a price below a specific value.
     *
     * @param price the maximum price
     * @return a list of properties with a price below the specified value
     */
    List<Property> findPropertiesByPriceLessThan(double price);

    /**
     * Retrieves all properties.
     *
     * @return a list of all properties
     */
    List<Property> findAll();
}