package com.revature.hotelbooking.hotelbooking.controllers;

import com.revature.hotelbooking.hotelbooking.repositories.BookingRepository;

import java.util.List;

import com.revature.hotelbooking.hotelbooking.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hotel")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/hotel/{hotelId}/booking")
    public List<Booking> getBookingsByHotelId(@PathVariable Long hotelId) {
        return bookingRepository.findByHotelId(hotelId);
    }

    @PostMapping("/hotel")
    
}
