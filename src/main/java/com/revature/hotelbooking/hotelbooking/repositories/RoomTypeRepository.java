package com.revature.hotelbooking.hotelbooking.repositories;

import com.revature.hotelbooking.hotelbooking.models.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {}
