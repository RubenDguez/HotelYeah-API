package com.revature.hotelbooking.hotelbooking.controllers;

import javax.validation.Valid;

import com.revature.hotelbooking.hotelbooking.exceptions.ResourceNotFoundException;
import com.revature.hotelbooking.hotelbooking.models.RoomStatus;
import com.revature.hotelbooking.hotelbooking.repositories.RoomStatusRepository;

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
@RequestMapping(value = "/roomstatus")
@CrossOrigin("http://localhost:3000")
public class RoomStatusController {

    @Autowired
    private RoomStatusRepository roomStatusRepo;

    @GetMapping("")
    public Page<RoomStatus> getRoomsStatus(Pageable pageable) {
        return roomStatusRepo.findAll(pageable);
    }

    @PostMapping("")
    public RoomStatus createRoomStatus(@Valid @RequestBody RoomStatus roomStatusRequest) {
        return roomStatusRepo.save(roomStatusRequest);
    }

    @PutMapping("/{id}")
    public RoomStatus updateRoomStatus(@PathVariable Long id, @Valid @RequestBody RoomStatus roomStatusRequest) {
        return roomStatusRepo.findById(id).map(roomStatus -> {

            roomStatus.setCode(roomStatusRequest.getCode());
            roomStatus.setDescription(roomStatusRequest.getDescription());
            return roomStatusRepo.save(roomStatus);

        }).orElseThrow(() -> new ResourceNotFoundException("Room Status not found with id " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoomStatus(@PathVariable Long id) {
        return roomStatusRepo.findById(id).map(roomStatus -> {
            roomStatusRepo.delete(roomStatus);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Room Status not found with id " + id));
    }    
    
}
