package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "properties")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Location is mandatory")
    private String location;

    @Positive(message = "Price must be positive")
    private double price;

    @Min(value = 1, message = "There must be at least one bedroom")
    private int bedrooms;

    @NotBlank(message = "Type is mandatory")
    private String type;

    @Positive(message = "Agent ID must be positive")
    private int agentId;


//    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
//    private List<Booking> bookings;

//    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
//    private List<Review> reviews;

}