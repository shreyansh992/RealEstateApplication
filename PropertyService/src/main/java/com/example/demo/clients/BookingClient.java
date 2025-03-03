package com.example.demo.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.DTO.BookingDTO;

/**
 * Feign client for interacting with the Booking service.
 * 
 * @author Shreyansh Singh
 */
@FeignClient(name = "bookings", url = "http://localhost:9003/bookings")
public interface BookingClient {
	
	/**
     * Creates a new booking.
     * 
     * @param bookingDTO the booking data transfer object containing booking details
     * @return a message indicating the result of the operation
     */
	@PostMapping("/save")
    public String createBooking(@RequestBody BookingDTO bookingDTO); 
}
