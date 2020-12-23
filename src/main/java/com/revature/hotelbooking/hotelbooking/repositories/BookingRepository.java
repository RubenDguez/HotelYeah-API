package com.revature.hotelbooking.hotelbooking.repositories;

import java.util.List;
import com.revature.hotelbooking.hotelbooking.models.Booking;
import com.revature.hotelbooking.hotelbooking.models.Guest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByHotelId(Long hotelId);
    List<Guest> findByGuestId(Long guestId);
    
}
