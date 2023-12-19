package com.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

}
