package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.BookingDTO;
import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;

/**
 * REST controller for managing bookings.
 * 
 * @author Shreyansh Singh
 */
@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    /**
     * Creates a new booking.
     * 
     * @param bookingDTO the booking data transfer object containing booking details
     * @return a message indicating the result of the operation
     */
    @PostMapping("/save")
    public String createBooking(@RequestBody BookingDTO bookingDTO) {
        return bookingService.createBooking(bookingDTO);
    }
    /**
     * Updates an existing booking.
     * 
     * @param id the ID of the booking to update
     * @param booking the updated booking information
     * @return the updated booking
     */
    @PutMapping("/update/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        Booking updatedBooking = bookingService.updateBooking(id, booking);
        return updatedBooking;
    }
    /**
     * Deletes a booking by ID.
     * 
     * @param id the ID of the booking to delete
     * @return a message indicating the result of the operation
     */
    @DeleteMapping("/delete/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "Booking Deleted successfully!";
    }
    /**
     * Retrieves a booking by ID.
     * 
     * @param id the ID of the booking to retrieve
     * @return the booking, if found
     */
    @GetMapping("/get/{id}")
    public Optional<Booking> getBookingById(@PathVariable Long id) {
        Optional<Booking> booking = bookingService.findBookingById(id);
        return booking;
    }
    /**
     * Retrieves bookings by user ID.
     * 
     * @param userId the ID of the user whose bookings to retrieve
     * @return a list of bookings for the specified user
     */
    @GetMapping("/byUserId/{userId}")
    public List<Booking> getBookingsByUserId(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.findBookingsByUserId(userId);
        return bookings;
    }
    /**
     * Retrieves bookings by property ID.
     * 
     * @param propertyId the ID of the property whose bookings to retrieve
     * @return a list of bookings for the specified property
     */
    @GetMapping("/byPropertyId/{propertyId}")
    public List<Booking> getBookingsByPropertyId(@PathVariable Long propertyId) {
        List<Booking> bookings = bookingService.findBookingsByPropertyId(propertyId);
        return bookings;
    }
    /**
     * Retrieves bookings by status.
     * 
     * @param status the status of the bookings to retrieve
     * @return a list of bookings with the specified status
     */
    @GetMapping("/byStatus/{status}")
    public List<Booking> getBookingsByStatus(@PathVariable String status) {
        List<Booking> bookings = bookingService.findBookingsByStatus(status);
        return bookings;
    }
    /**
     * Retrieves bookings within a specified date range.
     * 
     * @param startDate the start date of the range
     * @param endDate the end date of the range
     * @return a list of bookings within the specified date range
     */
    @GetMapping("/dateRange/{startDate}/{endDate}")
    public List<Booking> getBookingsByDateRange(@PathVariable("startDate") LocalDate startDate, @PathVariable("endDate") LocalDate endDate) {
        List<Booking> bookings = bookingService.findBookingsByDateRange(startDate, endDate);
        return bookings;
    }
    /**
     * Retrieves bookings by user ID and status.
     * 
     * @param userId the ID of the user whose bookings to retrieve
     * @param status the status of the bookings to retrieve
     * @return a list of bookings for the specified user and status
     */
    @GetMapping("/byUserIdAndStatus/{userId}/{status}")
    public List<Booking> getBookingsByUserIdAndStatus(@PathVariable Long userId, @PathVariable String status) {
        List<Booking> bookings = bookingService.findBookingsByUserIdAndStatus(userId, status);
        return bookings;
    }
    /**
     * Retrieves bookings by property ID and status.
     * 
     * @param propertyId the ID of the property whose bookings to retrieve
     * @param status the status of the bookings to retrieve
     * @return a list of bookings for the specified property and status
     */
    @GetMapping("/byPropertyIdAndStatus/{propertyId}/{status}")
    public List<Booking> getBookingsByPropertyIdAndStatus(@PathVariable Long propertyId, @PathVariable String status) {
        List<Booking> bookings = bookingService.findBookingsByPropertyIdAndStatus(propertyId, status);
        return bookings;
    }
}