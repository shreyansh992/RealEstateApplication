package com.example.demo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.DTO.BookingDTO;

@FeignClient(name = "bookings", url = "http://localhost:9003/bookings")
public interface BookingClient {
	
	@PostMapping("/save")
    public String createBooking(@RequestBody BookingDTO bookingDTO); 
}
