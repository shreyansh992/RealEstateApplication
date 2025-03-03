package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
	
	private String name;
    private String location;
    private double price;
    private int bedrooms;
    private String type;
    private int agentId; 
}
