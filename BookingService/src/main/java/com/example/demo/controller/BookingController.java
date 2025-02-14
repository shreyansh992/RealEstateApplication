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

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/save")
    public String createBooking(@RequestBody BookingDTO bookingDTO) {
        return bookingService.createBooking(bookingDTO);
    }

    @PutMapping("/update/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        Booking updatedBooking = bookingService.updateBooking(id, booking);
        return updatedBooking;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "Booking Deleted successfully!";
    }

    @GetMapping("/get/{id}")
    public Optional<Booking> getBookingById(@PathVariable Long id) {
        Optional<Booking> booking = bookingService.findBookingById(id);
        return booking;
    }

    @GetMapping("/byUserId/{userId}")
    public List<Booking> getBookingsByUserId(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.findBookingsByUserId(userId);
        return bookings;
    }

    @GetMapping("/byPropertyId/{propertyId}")
    public List<Booking> getBookingsByPropertyId(@PathVariable Long propertyId) {
        List<Booking> bookings = bookingService.findBookingsByPropertyId(propertyId);
        return bookings;
    }

    @GetMapping("/byStatus/{status}")
    public List<Booking> getBookingsByStatus(@PathVariable String status) {
        List<Booking> bookings = bookingService.findBookingsByStatus(status);
        return bookings;
    }

    @GetMapping("/dateRange")
    public List<Booking> getBookingsByDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        List<Booking> bookings = bookingService.findBookingsByDateRange(startDate, endDate);
        return bookings;
    }

    @GetMapping("/byUserIdAndStatus/{userId}/{status}")
    public List<Booking> getBookingsByUserIdAndStatus(@PathVariable Long userId, @PathVariable String status) {
        List<Booking> bookings = bookingService.findBookingsByUserIdAndStatus(userId, status);
        return bookings;
    }

    @GetMapping("/byPropertyIdAndStatus/{propertyId}/{status}")
    public List<Booking> getBookingsByPropertyIdAndStatus(@PathVariable Long propertyId, @PathVariable String status) {
        List<Booking> bookings = bookingService.findBookingsByPropertyIdAndStatus(propertyId, status);
        return bookings;
    }
}