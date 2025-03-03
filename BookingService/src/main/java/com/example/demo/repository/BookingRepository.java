package com.example.demo.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Booking;

/**
 * Repository interface for managing bookings.
 * 
 * @author Shreyansh Singh
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	/**
     * Finds bookings by user ID.
     * 
     * @param userId the ID of the user whose bookings to retrieve
     * @return a list of bookings for the specified user
     */
    List<Booking> findByUserId(Long userId);
    /**
     * Finds bookings by property ID.
     * 
     * @param propertyId the ID of the property whose bookings to retrieve
     * @return a list of bookings for the specified property
     */
    List<Booking> findByPropertyId(Long propertyId);
    /**
     * Finds bookings by status.
     * 
     * @param status the status of the bookings to retrieve
     * @return a list of bookings with the specified status
     */
    List<Booking> findByStatus(String status);
    /**
     * Finds bookings within a specified date range.
     * 
     * @param startDate the start date of the range
     * @param endDate the end date of the range
     * @return a list of bookings within the specified date range
     */
    List<Booking> findByBookingDateBetween(LocalDate startDate, LocalDate endDate);

    /**
     * Finds bookings by user ID and status.
     * 
     * @param userId the ID of the user whose bookings to retrieve
     * @param status the status of the bookings to retrieve
     * @return a list of bookings for the specified user and status
     */
    @Query("SELECT b FROM Booking b WHERE b.userId = :userId AND b.status = :status")
    List<Booking> findByUserIdAndStatus(@Param("userId") Long userId, @Param("status") String status);

    /**
     * Finds bookings by property ID and status.
     * 
     * @param propertyId the ID of the property whose bookings to retrieve
     * @param status the status of the bookings to retrieve
     * @return a list of bookings for the specified property and status
     */
    @Query("SELECT b FROM Booking b WHERE b.propertyId = :propertyId AND b.status = :status")
    List<Booking> findByPropertyIdAndStatus(@Param("propertyId") Long propertyId, @Param("status") String status);
}
