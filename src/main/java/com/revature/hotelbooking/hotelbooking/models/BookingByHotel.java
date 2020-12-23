package com.revature.hotelbooking.hotelbooking.models;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Table(name = "booking")
public class BookingByHotel extends AuditModel {

    private static final long serialVersionUID = 1L;
 
    @NotNull
    private Long id;
    
    @NotNull
    private Date checkInDate;       // check in date
    
    @NotNull
    private Date checkOutDate;      // check out date
    
    @NotNull
    private short roomCount;        // refers to the quantity of rooms being booking 

    // Relation Many to One on hotels table
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private Hotel hotel;

    // Relation Many to One on guests table
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "guest_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Guest guest;


    public BookingByHotel() {
        super();
    }

    public Long getId() {
        return id;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public short getRoomCount() {
        return roomCount;
    }

    public Guest getGuest() {
        return guest;
    }
    
}
