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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/booking")
@CrossOrigin(
    allowCredentials = "true",
    origins = "http://localhost:3000", 
    allowedHeaders = {"Content-Type", "x-requested-with", "origin", "Access-Control-Allow-Origin"}, 
    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}
)
public class BookingController {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private HotelRepository hotelRepo;

    @Autowired
    private GuestRepository guestRepo;

    @CrossOrigin
    @GetMapping("")
    public Page<Booking> getAllBookings(Pageable pageable) {
        return bookingRepo.findAll(pageable);
    }

    @CrossOrigin
    @GetMapping("/{bookingId}")
    public Optional<Booking> getBookingById(@PathVariable Long bookingId) {
        return bookingRepo.findById(bookingId);
    }

    @CrossOrigin
    @GetMapping("/hotel/{hotelId}")
    public List<Booking> getBookingByHotel(@PathVariable Long hotelId) {
        return bookingRepo.findByHotelId(hotelId);
    }

    @CrossOrigin
    @GetMapping("/guest/{guestId}")
    public List<Booking> getBookingByGuest(@PathVariable Long guestId) {
        return bookingRepo.findByGuestId(guestId);
    }

    @CrossOrigin
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

    @CrossOrigin
    @PutMapping("/{bookingId}")
    public Booking updateBooking(@PathVariable Long bookingId, @Valid @RequestBody Booking bookingRequest) {
        return bookingRepo.findById(bookingId).map(booking -> {
            booking.setCheckInDate(bookingRequest.getCheckInDate());
            booking.setCheckOutDate(bookingRequest.getCheckOutDate());
            booking.setRoomCount(bookingRequest.getRoomCount());
            return bookingRepo.save(booking);
        }).orElseThrow(() -> new ResourceNotFoundException("Booking not found by id " + bookingId));
    }

    @CrossOrigin
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long bookingId) {
        return bookingRepo.findById(bookingId).map(booking -> {
            bookingRepo.delete(booking);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + bookingId));
    }


    
}
