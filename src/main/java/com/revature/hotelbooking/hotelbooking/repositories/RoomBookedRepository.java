package com.revature.hotelbooking.hotelbooking.repositories;

import java.util.List;
import com.revature.hotelbooking.hotelbooking.models.RoomBooked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomBookedRepository extends JpaRepository<RoomBooked, Long> {
    List<RoomBooked> findByBookingId(Long bookingId);
}
