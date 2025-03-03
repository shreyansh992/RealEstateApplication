package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.BookingDTO;
import com.example.demo.entity.Booking;
import com.example.demo.exceptions.BookingNotFound;
import com.example.demo.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public String createBooking(BookingDTO bookingDTO) {
    	Booking booking = new Booking();
        booking.setUserId(bookingDTO.getUserId());
        booking.setPropertyId(bookingDTO.getPropertyId());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setStatus(bookingDTO.getStatus());
    	bookingRepository.save(booking);
     	return "Booking Created Successfully!";
    }

    @Override
    public Booking updateBooking(Long bookingId, Booking booking) {
        Optional<Booking> existingBooking = findBookingById(bookingId);
        if (existingBooking.isPresent()) {
            Booking updatedBooking = existingBooking.get();
            updatedBooking.setUserId(booking.getUserId());
            updatedBooking.setPropertyId(booking.getPropertyId());
            updatedBooking.setBookingDate(booking.getBookingDate());
            updatedBooking.setStatus(booking.getStatus());
            return bookingRepository.save(updatedBooking);
        } else {
            throw new BookingNotFound("Booking not found with id " + bookingId);
        }
    }


	@Override
    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    @Override
    public Optional<Booking> findBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public List<Booking> findBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public List<Booking> findBookingsByPropertyId(Long propertyId) {
        return bookingRepository.findByPropertyId(propertyId);
    }

    @Override
    public List<Booking> findBookingsByStatus(String status) {
        return bookingRepository.findByStatus(status);
    }

    @Override
    public List<Booking> findBookingsByDateRange(LocalDate startDate, LocalDate endDate) {
        return bookingRepository.findByBookingDateBetween(startDate, endDate);
    }

    @Override
    public List<Booking> findBookingsByUserIdAndStatus(Long userId, String status) {
        return bookingRepository.findByUserIdAndStatus(userId, status);
    }

    @Override
    public List<Booking> findBookingsByPropertyIdAndStatus(Long propertyId, String status) {
        return bookingRepository.findByPropertyIdAndStatus(propertyId, status);
    }
}