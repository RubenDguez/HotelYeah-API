package com.revature.hotelbooking.hotelbooking.repositories;

import com.revature.hotelbooking.hotelbooking.models.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{}
