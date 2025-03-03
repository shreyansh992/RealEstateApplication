package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.BookingDTO;
import com.example.demo.clients.BookingClient;
import com.example.demo.entity.Property;
import com.example.demo.exceptions.PropertyNotFound;
import com.example.demo.repository.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;
    
    @Autowired
    BookingClient client;

    @Override
    public String createProperty(Property property) {
        propertyRepository.save(property);
        return "Property Created Successfully!";
    }

    @Override
    public Property updateProperty(Long propertyId, Property property) {
        Optional<Property> existingProperty = propertyRepository.findById(propertyId);
        if (existingProperty.isPresent()) {
            Property updatedProperty = existingProperty.get();
            updatedProperty.setName(property.getName());
            updatedProperty.setLocation(property.getLocation());
            updatedProperty.setPrice(property.getPrice());
            updatedProperty.setBedrooms(property.getBedrooms());
            updatedProperty.setType(property.getType());
            updatedProperty.setAgentId(property.getAgentId());
            return propertyRepository.save(updatedProperty);
        } else {
            throw new PropertyNotFound("Property not found with id " + propertyId);
        }
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }

    @Override
    public Optional<Property> findPropertyById(Long propertyId) {
        return propertyRepository.findById(propertyId);
    }

    @Override
    public List<Property> findPropertiesByLocation(String location) {
        return propertyRepository.findByLocation(location);
    }

    @Override
    public List<Property> findPropertiesByPriceRange(double minPrice, double maxPrice) {
        return propertyRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Property> findPropertiesByType(String type) {
        return propertyRepository.findByType(type);
    }

    @Override
    public List<Property> findPropertiesByBedrooms(int bedrooms) {
        return propertyRepository.findByBedrooms(bedrooms);
    }

    @Override
    public List<Property> findPropertiesByNameContainsIgnoreCase(String name) {
        return propertyRepository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public List<Property> findPropertiesByPriceGreaterThan(double price) {
        return propertyRepository.findByPriceGreaterThan(price);
    }

    @Override
    public List<Property> findPropertiesByPriceLessThan(double price) {
        return propertyRepository.findByPriceLessThan(price);
    }

	@Override
	public List<Property> findAll() {
			return propertyRepository.findAll();
	}

	@Override
	public String createBooking(BookingDTO bookingDTO) {
		return client.createBooking(bookingDTO);
	}

	
}
