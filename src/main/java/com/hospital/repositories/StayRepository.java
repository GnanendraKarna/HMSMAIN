package com.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entities.Stay;

public interface StayRepository extends JpaRepository<Stay, Integer> {

}
