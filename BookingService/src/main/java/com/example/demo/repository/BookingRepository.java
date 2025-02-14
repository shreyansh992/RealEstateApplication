package com.example.demo.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUserId(Long userId);
    List<Booking> findByPropertyId(Long propertyId);
    List<Booking> findByStatus(String status);
    List<Booking> findByBookingDateBetween(LocalDate startDate, LocalDate endDate);

    // Custom query to find bookings by user ID and status
    @Query("SELECT b FROM Booking b WHERE b.userId = :userId AND b.status = :status")
    List<Booking> findByUserIdAndStatus(@Param("userId") Long userId, @Param("status") String status);

    // Custom query to find bookings by property ID and status
    @Query("SELECT b FROM Booking b WHERE b.propertyId = :propertyId AND b.status = :status")
    List<Booking> findByPropertyIdAndStatus(@Param("propertyId") Long propertyId, @Param("status") String status);
}
