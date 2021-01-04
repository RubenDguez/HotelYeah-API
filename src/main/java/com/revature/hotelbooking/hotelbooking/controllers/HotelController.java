package com.revature.hotelbooking.hotelbooking.controllers;

import javax.validation.Valid;

import com.revature.hotelbooking.hotelbooking.exceptions.ResourceNotFoundException;
import com.revature.hotelbooking.hotelbooking.models.Hotel;
import com.revature.hotelbooking.hotelbooking.repositories.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://18.218.171.150:8081"})
@RequestMapping("/hotel")
public class HotelController {
    
    @Autowired
    private HotelRepository hotelRepo;

    @GetMapping("")
    public Page<Hotel> getHotels(Pageable pageable) {
        return hotelRepo.findAll(pageable);
    }

    @PostMapping("")
    public Hotel createHotel(@Valid @RequestBody Hotel hotelRequest) {
        return hotelRepo.save(hotelRequest);
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Long id, @Valid @RequestBody Hotel hotelRequest) {
        return hotelRepo.findById(id).map(hotel -> {
            
                    hotel.setCode(hotelRequest.getCode());
                    hotel.setName(hotelRequest.getName());
                    hotel.setAddress(hotelRequest.getAddress());
                    hotel.setAddress2(hotelRequest.getAddress2());
                    hotel.setCity(hotelRequest.getCity());
                    hotel.setState(hotelRequest.getState());
                    hotel.setZipCode(hotelRequest.getZipCode());
                    hotel.setMainPhoneNumber(hotelRequest.getMainPhoneNumber());
                    hotel.setFaxNumber(hotelRequest.getFaxNumber());
                    hotel.setEmailAddress(hotelRequest.getEmailAddress());
                    hotel.setWebsiteAddress(hotelRequest.getWebsiteAddress());
                    hotel.setImagePath(hotelRequest.getImagePath());
               
            return hotelRepo.save(hotel);
        }).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable Long id) {
        return hotelRepo.findById(id).map(hotel -> {
            hotelRepo.delete(hotel);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id " + id));
    }


}
