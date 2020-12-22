package com.revature.hotelbooking.hotelbooking.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "guest")
public class Guest extends AuditModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "guests_generator")
    @SequenceGenerator(name = "guests_generator", sequenceName = "guests_generator", initialValue = 1000)
    private Long id;

    @NotNull
    private String firstName;
    
    @NotNull
    private String lastName;
    
    @NotNull
    private String address;
    private String address2;
    
    @NotNull
    private String city;
    
    @NotNull
    private String state;
    
    @NotNull
    private int zipCode;
    
    @NotNull
    private String country;

    private String homePhoneNumber;
    
    @NotNull
    private String cellPhoneNumber;
    private String emailAddress;

    public Guest() {
        super();
    }

    public Guest(String firstName, String lastName, String address, String address2, String city, String state,
            int zipCode, String country, String homePhoneNumber, String cellPhoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.homePhoneNumber = homePhoneNumber;
        this.cellPhoneNumber = cellPhoneNumber;
        this.emailAddress = emailAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    

    
    
}
