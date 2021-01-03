package com.revature.hotelbooking.hotelbooking.controllers;

import javax.validation.Valid;

import com.revature.hotelbooking.hotelbooking.exceptions.ResourceNotFoundException;
import com.revature.hotelbooking.hotelbooking.models.Guest;
import com.revature.hotelbooking.hotelbooking.repositories.GuestRepository;

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
@RequestMapping(value = "/guest")
@CrossOrigin(
    allowCredentials = "true",
    origins = "http://localhost:3000", 
    allowedHeaders = {"Content-Type", "x-requested-with", "origin", "Access-Control-Allow-Origin"},  
    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}
)
public class GuestController {
    
    @Autowired
    private GuestRepository guestRepo;

    @CrossOrigin
    @GetMapping("")
    public Page<Guest> getGuests(Pageable pageable) {
        return guestRepo.findAll(pageable);
    }

    @CrossOrigin
    @PostMapping("")
    public Guest createGuest(@Valid @RequestBody Guest guestRequest) {
        return guestRepo.save(guestRequest);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable Long id, @Valid @RequestBody Guest guestRequest) {
        return guestRepo.findById(id).map(guest -> {
            
                    guest.setFirstName(guestRequest.getFirstName());
                    guest.setLastName(guestRequest.getLastName());
                    guest.setAddress(guestRequest.getAddress());
                    guest.setAddress2(guestRequest.getAddress2());
                    guest.setCity(guestRequest.getCity());
                    guest.setState(guestRequest.getState());
                    guest.setZipCode(guestRequest.getZipCode());
                    guest.setCountry(guestRequest.getCountry());
                    guest.setHomePhoneNumber(guestRequest.getHomePhoneNumber());
                    guest.setCellPhoneNumber(guestRequest.getCellPhoneNumber());
                    guest.setEmailAddress(guestRequest.getEmailAddress());
               
            return guestRepo.save(guest);
        }).orElseThrow(() -> new ResourceNotFoundException("Guest not found with id " + id));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGuest(@PathVariable Long id) {
        return guestRepo.findById(id).map(guest -> {
            guestRepo.delete(guest);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Guest not found with id " + id));
    }


}
