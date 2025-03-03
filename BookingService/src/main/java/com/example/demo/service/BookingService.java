package com.example.demo.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.BookingDTO;
import com.example.demo.entity.Booking;

/**
 * Service interface for managing bookings.
 * 
 * @author Shreyansh Singh
 */
public interface BookingService {

	/**
     * Creates a new booking.
     * 
     * @param bookingDTO the booking data transfer object containing booking details
     * @return a message indicating the result of the operation
     */
    String createBooking(BookingDTO bookingDTO);
    /**
     * Updates an existing booking.
     * 
     * @param bookingId the ID of the booking to update
     * @param booking the updated booking information
     * @return the updated booking
     */
    Booking updateBooking(Long bookingId, Booking booking);
    /**
     * Deletes a booking by ID.
     * 
     * @param bookingId the ID of the booking to delete
     */
    void deleteBooking(Long bookingId);
    /**
     * Retrieves a booking by ID.
     * 
     * @param bookingId the ID of the booking to retrieve
     * @return the booking, if found
     */
    Optional<Booking> findBookingById(Long bookingId);
    /**
     * Retrieves bookings by user ID.
     * 
     * @param userId the ID of the user whose bookings to retrieve
     * @return a list of bookings for the specified user
     */
    List<Booking> findBookingsByUserId(Long userId);
    /**
     * Retrieves bookings by property ID.
     * 
     * @param propertyId the ID of the property whose bookings to retrieve
     * @return a list of bookings for the specified property
     */
    List<Booking> findBookingsByPropertyId(Long propertyId);
    /**
     * Retrieves bookings by status.
     * 
     * @param status the status of the bookings to retrieve
     * @return a list of bookings with the specified status
     */
    List<Booking> findBookingsByStatus(String status);
    /**
     * Retrieves bookings within a specified date range.
     * 
     * @param startDate the start date of the range
     * @param endDate the end date of the range
     * @return a list of bookings within the specified date range
     */
    List<Booking> findBookingsByDateRange(LocalDate startDate, LocalDate endDate);
    /**
     * Retrieves bookings by user ID and status.
     * 
     * @param userId the ID of the user whose bookings to retrieve
     * @param status the status of the bookings to retrieve
     * @return a list of bookings for the specified user and status
     */
    List<Booking> findBookingsByUserIdAndStatus(Long userId, String status);
    /**
     * Retrieves bookings by property ID and status.
     * 
     * @param propertyId the ID of the property whose bookings to retrieve
     * @param status the status of the bookings to retrieve
     * @return a list of bookings for the specified property and status
     */
    List<Booking> findBookingsByPropertyIdAndStatus(Long propertyId, String status);

	
}
