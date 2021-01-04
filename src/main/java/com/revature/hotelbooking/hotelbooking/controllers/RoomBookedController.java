package com.revature.hotelbooking.hotelbooking.controllers;

import com.revature.hotelbooking.hotelbooking.repositories.RoomBookedRepository;

import java.util.List;
import com.revature.hotelbooking.hotelbooking.models.RoomBooked;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://18.218.171.150:8081"})
public class RoomBookedController {

    private RoomBookedRepository roomBookedRepo;

    @GetMapping("/booking/{bookingId}/roombooked")
    public List<RoomBooked> getRoomBookedByBookingId(@PathVariable Long bookingId) {
        return roomBookedRepo.findByBookingId(bookingId);
    }

}
