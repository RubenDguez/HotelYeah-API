package com.revature.hotelbooking.hotelbooking.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Hotel extends AuditModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "hotel_generator")
    @SequenceGenerator(name = "hotel_generator", sequenceName = "hotel_generator", initialValue = 1000)
    private Long id;
    
    @NotBlank
    @Size(min = 3, max = 10)
    private String code;

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String address;

    @Size(max = 100)
    private String address2;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private int zipCode;

    @NotBlank
    private String mainPhoneNumber;
   
    private String faxNumber;

    @NotBlank
    private String emailAddress;

    private String websiteAddress;
    private String imagePath;    

    public Hotel() {
        super();
    }

    public Hotel(String code, String name, String address, String address2, String city, String state, int zipCode, String mainPhoneNumber, String faxNumber, String emailAddress, String websiteAddress, String imagePath) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.mainPhoneNumber = mainPhoneNumber;
        this.faxNumber = faxNumber;
        this.emailAddress = emailAddress;
        this.websiteAddress = websiteAddress;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMainPhoneNumber() {
        return mainPhoneNumber;
    }

    public void setMainPhoneNumber(String mainPhoneNumber) {
        this.mainPhoneNumber = mainPhoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getWebsiteAddress() {
        return websiteAddress;
    }

    public void setWebsiteAddress(String websiteAddress) {
        this.websiteAddress = websiteAddress;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    
}
