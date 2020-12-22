package com.revature.hotelbooking.hotelbooking.models;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "booking")
public class Booking extends AuditModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "booking_generator")
    @SequenceGenerator(name = "booking_generator", sequenceName = "booking_generator", initialValue = 1000)
    private Long id;
    
    @NotNull
    private Date checkInDate;       // check in date
    
    @NotNull
    private Date checkOutDate;      // check out date
    
    @NotNull
    private short roomCount;        // refers to the quantity of rooms being booking 

    // Relation Many to One on hotels table
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hotel_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private Hotel hotel;

    // Relation Many to One on guests table
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "guest_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private Guest guest;


    public Booking() {
        super();
    }

    public Booking(Date checkInDate, Date checkOutDate, short roomCount, Hotel hotel, Guest guest) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomCount = roomCount;
        this.hotel = hotel;
        this.guest = guest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public short getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(short roomCount) {
        this.roomCount = roomCount;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }        
    
}
