package com.revature.hotelbooking.hotelbooking.controllers;

import com.revature.hotelbooking.hotelbooking.repositories.BookingRepository;
import com.revature.hotelbooking.hotelbooking.repositories.GuestRepository;
import com.revature.hotelbooking.hotelbooking.repositories.HotelRepository;

import java.util.List;
import java.util.Optional;

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
@RequestMapping(value = "/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private HotelRepository hotelRepo;

    @Autowired
    private GuestRepository guestRepo;

    @GetMapping("/{bookingId}")
    public Optional<Booking> getBookingById(@PathVariable Long bookingId) {
        return bookingRepo.findById(bookingId);
    }

    @GetMapping("/hotel/{hotelId}")
    public List<Booking> getBookingByHotel(@PathVariable Long hotelId) {
        return bookingRepo.findByHotelId(hotelId);
    }

    @PostMapping("/{hotelId}/{guestId}")
    public Booking addBooking(@PathVariable Long hotelId, @PathVariable Long guestId, @Valid @RequestBody Booking booking) {
        return hotelRepo.findById(hotelId).map(hotel -> {
            return guestRepo.findById(guestId).map(guest -> {

                booking.setHotel(hotel);
                booking.setGuest(guest);
                return bookingRepo.save(booking);

            }).orElseThrow(() -> new ResourceNotFoundException("Guest not found by id " + guestId));
        }).orElseThrow(() -> new ResourceNotFoundException("Hotel not found by id " + hotelId));
    }
    
}
