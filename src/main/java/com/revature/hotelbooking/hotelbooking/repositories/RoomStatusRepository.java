package com.revature.hotelbooking.hotelbooking.repositories;

import com.revature.hotelbooking.hotelbooking.models.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomStatusRepository extends JpaRepository<RoomStatus, Long> {}
