package com.example.demo.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.BookingDTO;
import com.example.demo.entity.Booking;

public interface BookingService {

    String createBooking(BookingDTO bookingDTO);
    Booking updateBooking(Long bookingId, Booking booking);
    void deleteBooking(Long bookingId);
    Optional<Booking> findBookingById(Long bookingId);
    List<Booking> findBookingsByUserId(Long userId);
    List<Booking> findBookingsByPropertyId(Long propertyId);
    List<Booking> findBookingsByStatus(String status);
    List<Booking> findBookingsByDateRange(LocalDate startDate, LocalDate endDate);
    List<Booking> findBookingsByUserIdAndStatus(Long userId, String status);
    List<Booking> findBookingsByPropertyIdAndStatus(Long propertyId, String status);

	
}
