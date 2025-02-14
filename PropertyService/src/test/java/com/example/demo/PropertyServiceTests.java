package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Property;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.PropertyServiceImpl;

@SpringBootTest
class PropertyServiceTests {

	@Mock
    private PropertyRepository propertyRepository;

    @InjectMocks
    private PropertyServiceImpl propertyService;

    @Test
    public void testCreateProperty() {
        Property property = new Property();
        property.setId(1L);
        property.setName("Beautiful House");
        property.setLocation("New York");
        property.setPrice(500000);
        property.setBedrooms(3);
        property.setType("Residential");
        property.setAgentId(1);

        when(propertyRepository.save(property)).thenReturn(property);

        assertEquals("Property Created Successfully!", propertyService.createProperty(property));
        verify(propertyRepository, times(1)).save(property);
    }

}
