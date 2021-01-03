package com.revature.hotelbooking.hotelbooking.controllers;

import javax.validation.Valid;

import com.revature.hotelbooking.hotelbooking.exceptions.ResourceNotFoundException;
import com.revature.hotelbooking.hotelbooking.models.RoomType;
import com.revature.hotelbooking.hotelbooking.repositories.RoomTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/roomtype")
@CrossOrigin(
    allowCredentials = "true",
    origins = "http://localhost:3000", 
    allowedHeaders = {"Content-Type", "x-requested-with", "origin", "Access-Control-Allow-Origin"}, 
    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}
)
public class RoomTypeController {

    @Autowired
    private RoomTypeRepository roomTypeRepo;

    @CrossOrigin
    @GetMapping("")
    public Page<RoomType> getRoomsTypes(Pageable pageable) {
        return roomTypeRepo.findAll(pageable);
    }

    @CrossOrigin
    @PostMapping("")
    public RoomType createRoomType(@Valid @RequestBody RoomType roomTypeRequest) {
        return roomTypeRepo.save(roomTypeRequest);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public RoomType updateRoomType(@PathVariable Long id, @Valid @RequestBody RoomType roomTypeRequest) {
        return roomTypeRepo.findById(id).map(roomType -> {

            roomType.setCode(roomTypeRequest.getCode());
            roomType.setDescription(roomTypeRequest.getDescription());
            return roomTypeRepo.save(roomType);

        }).orElseThrow(() -> new ResourceNotFoundException("Room Type not found with id " + id));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoomType(@PathVariable Long id) {
        return roomTypeRepo.findById(id).map(roomType -> {
            roomTypeRepo.delete(roomType);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Room Type not found with id " + id));
    }    
    
}
