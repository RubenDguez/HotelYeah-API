# HotelBooking API

## Endpoints:
- ```http://3.139.235.28:8080/hotelbooking-1.0.0/hotel```
    
    - GET
    - POST
        - Example body:
        ```
        {
            "code":"FLOR123456", 
            "name":"RAMADA", 
            "address":"1321 Main St",
            "address2":"", 
            "city":"Orlando", 
            "state":"FL", 
            "zipCode":32809, 
            "mainPhoneNumber":"4073488975", 
            "faxNumber":"4071239876", 
            "emailAddress":"ramada@hotelramada.com", 
            "websiteAddress":"http://ramada.com", 
            "imagePath":"http://hello.com"
        }
        ```
    - PUT ```/{hotel id}```
    ```
    The body for PUT request is the same as the POST request
    ```
    - DELETE ```/{hotel id}```

---
- ```http://3.139.235.28:8080/hotelbooking-1.0.0/guest```
    - GET
    - POST
        - Example body:
        ```
        {
            "firstName":"Ruben", 
            "lastName":"Dominguez", 
            "address":"125 Main St", 
            "address2":"", 
            "city":"Clermont", 
            "state":"FL",
            "zipCode":"34714", 
            "country":"United States", 
            "homePhoneNumber":"4071254587", 
            "cellPhoneNumber":"4073256985", 
            "emailAddress":"ruben.dominguez@revature.net"
        }
        ```
    - PUT ```/{guest id}```
    ```
    The body for PUT request is the same as the POST request
    ```
    - DELETE ```/{guest id}```
---
- ```http://3.139.235.28:8080/hotelbooking-1.0.0/roomstatus```

    - GET
    - POST
        - Example body:
        ```
        {
            "code":"BOOK2P",
            "description":"Room has been booked but not payment has been provided"
        }
        ```
        - PUT ```/{roomstatus id}```
        ```
        The body for PUT requests is the same as the POST request
        ```
        - DELETE ```/{roomstatus id}```
---
- ```http://3.139.235.28:8080/hotelbooking-1.0.0/roomtype```
    - GET
    - POST
        - Example body:
        ```
        {
            "code":"REGSUIT",
            "description":"Regular Suite, with Ocean view"
        }
        ```
        - PUT ```/{roomtype id}```
        ```
        The body for PUT request is the same as POST request
        ```
        - DELETE ```/{roomtype id}```
---
- ```http://3.139.235.28:8080/hotelbooking-1.0.0/booking```
    - GET: Gets all bookings available in database
    - GET ```/{booking id}```
    - GET ```/hotel/{hotel id}``` Gets all bookings for a particular hotel
    - GET ```/guest/{guest id}``` Gets all bookings for a particular guest
    - POST ```/{hotel id}/{guest id}``` Creates a booking; Must indicate hotel id and user id in URL. It also needs body request
        - Example body:
        ```
       {
            "checkInDate":"2021-01-05", 
            "checkOutDate":"2021-01-15", 
            "roomCount":"1"
        } 
        ```
    - PUT ```/{booking id}``` Edit a particular booking. Needs same body as POST request with edited fields.
    - DELETE ```/{booking id}```
---
