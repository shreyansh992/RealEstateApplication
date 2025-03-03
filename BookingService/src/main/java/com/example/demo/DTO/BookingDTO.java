package com.example.demo.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
	private long id;
	private int userId;
	private int propertyId;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate bookingDate;
	private String status;

}
