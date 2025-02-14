package com.example.demo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.DTO.PropertyDTO;

@FeignClient(name = "properties", url = "http://localhost:9002/properties")
public interface PropertyClient {
	
	@PostMapping("/create")
	public String createProperty(@RequestBody PropertyDTO propertyDTO);
	
}
