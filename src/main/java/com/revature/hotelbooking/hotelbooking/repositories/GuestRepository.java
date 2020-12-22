package com.revature.hotelbooking.hotelbooking.repositories;

import com.revature.hotelbooking.hotelbooking.models.Guest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long>{}
