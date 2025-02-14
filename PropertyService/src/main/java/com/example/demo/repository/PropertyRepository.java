package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Property;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

	List<Property> findByLocation(String location);
    List<Property> findByPriceBetween(double minPrice, double maxPrice);
    List<Property> findByType(String type);
    List<Property> findByBedrooms(int bedrooms);
    Optional<Property> findById(Long id);

    // Custom query to find properties by name (case insensitive)
    @Query("SELECT p FROM Property p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Property> findByNameContainsIgnoreCase(@Param("name") String name);

    // Find properties with a price above a specific value
    List<Property> findByPriceGreaterThan(double price);

    // Find properties with a price below a specific value
    List<Property> findByPriceLessThan(double price);

    // Custom query to find properties by amenities (e.g., pool, gym)
//    @Query("SELECT p FROM Property p JOIN p.amenities a WHERE a.name = :amenity")
//    List<Property> findByAmenity(@Param("amenity") String amenity);
    
 // Method to get all properties
    List<Property> findAll();
}

