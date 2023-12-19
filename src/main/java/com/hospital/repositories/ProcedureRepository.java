package com.hospital.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entities.Procedure;

public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {

	List<Procedure> findByName(String name);

	Procedure findCostByName(String name);

}
