package com.revature.hotelbooking.hotelbooking.controllers;

import com.revature.hotelbooking.hotelbooking.repositories.BookingRepository;
import com.revature.hotelbooking.hotelbooking.repositories.HotelRepository;

import java.util.List;

import javax.validation.Valid;

import com.revature.hotelbooking.hotelbooking.exceptions.ResourceNotFoundException;
import com.revature.hotelbooking.hotelbooking.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hotel")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private HotelRepository hotelRepo;

    @GetMapping("/{hotelId}/booking")
    public List<Booking> getBookingsByHotelId(@PathVariable Long hotelId) {
        return bookingRepo.findByHotelId(hotelId);
    }

    @PostMapping("/{hotelId}/booking")
    public Booking addBooking(@PathVariable Long hotelId, @Valid @RequestBody Booking booking) {
        return hotelRepo.findById(hotelId).map(hotel -> {
            booking.setHotel(hotel);
            return bookingRepo.save(booking);
        }).orElseThrow(() -> new ResourceNotFoundException("Hotel not found by id " + hotelId));
    }
    
}
