package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Property;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing properties.
 * 
 * @author Shreyansh Singh
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

	 /**
     * Finds properties by location.
     * 
     * @param location the location to search for properties
     * @return a list of properties in the specified location
     */
	List<Property> findByLocation(String location);
	 /**
     * Finds properties within a specified price range.
     * 
     * @param minPrice the minimum price
     * @param maxPrice the maximum price
     * @return a list of properties within the specified price range
     */
	List<Property> findByPriceBetween(double minPrice, double maxPrice);
	/**
     * Finds properties by type.
     * 
     * @param type the type of property (e.g., apartment, house)
     * @return a list of properties of the specified type
     */
	List<Property> findByType(String type);
	/**
     * Finds properties by the number of bedrooms.
     * 
     * @param bedrooms the number of bedrooms
     * @return a list of properties with the specified number of bedrooms
     */
	List<Property> findByBedrooms(int bedrooms);
	/**
     * Finds a property by its ID.
     * 
     * @param id the ID of the property
     * @return an optional containing the property, if found
     */
	Optional<Property> findById(Long id);

	/**
     * Finds properties by name, case insensitive.
     * 
     * @param name the name of the property to search for
     * @return a list of properties with names containing the specified string, case insensitive
     */
	@Query("SELECT p FROM Property p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Property> findByNameContainsIgnoreCase(@Param("name") String name);
	/**
     * Finds properties with a price above a specific value.
     * 
     * @param price the minimum price
     * @return a list of properties with a price above the specified value
     */
    List<Property> findByPriceGreaterThan(double price);
    /**
     * Finds properties with a price below a specific value.
     * 
     * @param price the maximum price
     * @return a list of properties with a price below the specified value
     */
    List<Property> findByPriceLessThan(double price);

    /**
     * Retrieves all properties.
     * 
     * @return a list of all properties
     */
    List<Property> findAll();
}

