package com.revature.hotelbooking.hotelbooking.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "room_booked")
public class RoomBooked extends AuditModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "room_booked_generator")
    @SequenceGenerator(name = "room_booked_generator", sequenceName = "room_booked_generator", initialValue = 1000)
    private Long id;

    @NotBlank
    private double rate;

    // Relation Many to One on rooms
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private Room room;

    // Relation Many to One on bookings
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private Booking booking;

    public RoomBooked() {
        super();
    }

    public RoomBooked(double rate, Room room, Booking booking) {
        this.rate = rate;
        this.room = room;
        this.booking = booking;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    
    
}
