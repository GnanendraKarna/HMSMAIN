package com.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entities.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Integer> {

}
