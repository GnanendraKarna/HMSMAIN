package com.hospital.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entities.Physician;

public interface PhysicianRepository extends JpaRepository<Physician, Integer> {

	Physician findByName(String name);

	List<Physician> findByPosition(String position);
}
