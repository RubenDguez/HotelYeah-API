package com.revature.hotelbooking.hotelbooking.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "room")
public class Room extends AuditModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "room_generator")
    @SequenceGenerator(name = "room_generator", sequenceName = "room_generator", initialValue = 1000)
    private Long id;

    @NotBlank
    private short floor;

    @NotBlank
    private short roomNumber;

    @NotBlank
    private String description;

    // Relation Many to One on Hotel
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hotel_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private Hotel hotel;


    // Relation Many to One on RoomType
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_type_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private RoomType roomType;

    // Relation Many to One on RoomStatus
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_status_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private RoomStatus roomStatus;

    public Room() {
        super();
    }

    public Room(short floor, short roomNumber, String description, Hotel hotel, RoomType roomType,
            RoomStatus roomStatus) {
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.description = description;
        this.hotel = hotel;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getFloor() {
        return floor;
    }

    public void setFloor(short floor) {
        this.floor = floor;
    }

    public short getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(short roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }


    
}
