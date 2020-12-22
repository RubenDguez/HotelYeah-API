package com.revature.hotelbooking.hotelbooking.controllers;

import javax.validation.Valid;

import com.revature.hotelbooking.hotelbooking.exceptions.ResourceNotFoundException;
import com.revature.hotelbooking.hotelbooking.models.RoomType;
import com.revature.hotelbooking.hotelbooking.repositories.RoomTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
public class RoomTypeController {

    @Autowired
    private RoomTypeRepository roomTypeRepo;

    @GetMapping("")
    public Page<RoomType> getRoomsTypes(Pageable pageable) {
        return roomTypeRepo.findAll(pageable);
    }

    @PostMapping("")
    public RoomType createRoomType(@Valid @RequestBody RoomType roomTypeRequest) {
        return roomTypeRepo.save(roomTypeRequest);
    }

    @PutMapping("/{id}")
    public RoomType updateRoomType(@PathVariable Long id, @Valid @RequestBody RoomType roomTypeRequest) {
        return roomTypeRepo.findById(id).map(roomType -> {

            roomType.setCode(roomTypeRequest.getCode());
            roomType.setDescription(roomTypeRequest.getDescription());
            return roomTypeRepo.save(roomType);

        }).orElseThrow(() -> new ResourceNotFoundException("Room Type not found with id " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoomType(@PathVariable Long id) {
        return roomTypeRepo.findById(id).map(roomType -> {
            roomTypeRepo.delete(roomType);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Room Type not found with id " + id));
    }    
    
}
