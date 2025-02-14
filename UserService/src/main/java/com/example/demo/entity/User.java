package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Role is mandatory")
    private String role;

    @NotBlank(message = "Status is mandatory")
    private String status;

    private LocalDate createdDate;
    private LocalDate lastLoginDate;

//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private List<Booking> bookings;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Review> reviews;

}
