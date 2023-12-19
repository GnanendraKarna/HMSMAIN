package com.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entities.Nurse;

public interface NurseRepository extends JpaRepository<Nurse, Integer> {
	Nurse findByName(String name);
}
